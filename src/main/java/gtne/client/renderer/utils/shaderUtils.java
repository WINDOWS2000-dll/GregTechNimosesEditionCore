package gtne.client.renderer.utils;

import gtne.api.util.GTNELog;
import gtne.client.renderer.shader.ShaderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class shaderUtils {

    private static final int VERTEX = ARBVertexShader.GL_VERTEX_SHADER_ARB;
    private static final int FRAGMENT = ARBFragmentShader.GL_FRAGMENT_SHADER_ARB;
    private static final String PREFIX = "/assets/gtnecore/shader/";

    public static int cosmicShader = 0;

    public static void initShaders() {
        if (!useShaders()) {
            return;
        }

        cosmicShader = createShaderProgram("cosmic.vert", "cosmic.frag");
    }

    public static void useShader(int shader, ShaderCallback callback) {

        if (!useShaders()) {
            return;
        }

        ARBShaderObjects.glUseProgramObjectARB(shader);

        if (shader != 0) {
            int time = ARBShaderObjects.glGetUniformLocationARB(shader, "time");
            Minecraft minecraft = Minecraft.getMinecraft();
            if (minecraft.player != null && minecraft.player.world != null) {
                ARBShaderObjects.glUniform1iARB(time, (int) (minecraft.player.world.getWorldTime() % Integer.MAX_VALUE));
            }

            if (callback != null) {
                callback.call(shader);
            }
        }
    }

    public static void useShader(int shader) {
        useShader(shader, null);
    }

    public static void releaseShader() {
        useShader(0);
    }

    public static boolean useShaders() {
        return OpenGlHelper.shadersSupported;
    }

    private static int createShaderProgram(String vertex, String fragment) {
        int verticalID = 0, fragmentID = 0, program = 0;
        if (vertex != null) {
            verticalID = createShader(PREFIX + vertex, VERTEX);
        }
        if (fragment != null) {
            fragmentID = createShader(PREFIX + fragment, FRAGMENT);
        }

        program = ARBShaderObjects.glCreateProgramObjectARB();
        if (program == 0) {
            return 0;
        }

        if (vertex != null) {
            ARBShaderObjects.glAttachObjectARB(program, verticalID);
        }
        if (fragment != null) {
            ARBShaderObjects.glAttachObjectARB(program, fragmentID);
        }

        ARBShaderObjects.glLinkProgramARB(program);
        if (ARBShaderObjects.glGetObjectParameteriARB(program, ARBShaderObjects.GL_OBJECT_LINK_STATUS_ARB) == GL11.GL_FALSE) {
            GTNELog.logger.log(Level.ERROR, getLogInfo(program));
            return 0;
        }

        ARBShaderObjects.glValidateProgramARB(program);
        if (ARBShaderObjects.glGetObjectParameteriARB(program, ARBShaderObjects.GL_OBJECT_VALIDATE_STATUS_ARB) == GL11.GL_FALSE) {
            GTNELog.logger.log(Level.ERROR, getLogInfo(program));
            return 0;
        }

        return program;
    }

    private static int createShader(String filename, int shaderType) {
        int shader = 0;
        try {
            shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);

            if (shader == 0) {
                return 0;
            }

            ARBShaderObjects.glShaderSourceARB(shader, readFileAsString(filename));
            ARBShaderObjects.glCompileShaderARB(shader);

            if (ARBShaderObjects.glGetObjectParameteriARB(shader, ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB) == GL11.GL_FALSE) {
                throw new RuntimeException("ERROR CRATING SHADER \"" + filename + "\": " + getLogInfo(shader));
            }

            return shader;

        } catch (Exception exception) {
            ARBShaderObjects.glDeleteObjectARB(shader);
            exception.printStackTrace(); //身の程を知らないExceptionが堅固なLoggingに当たって砕けたようですね（笑）
            return -1;
        }
    }

    private static String getLogInfo(int objects) {
        return ARBShaderObjects.glGetInfoLogARB(objects, ARBShaderObjects.glGetObjectParameteriARB(objects, ARBShaderObjects.GL_OBJECT_INFO_LOG_LENGTH_ARB));
    }

    //ファイル読み込み
    private static String readFileAsString(String filename) throws Exception {
        StringBuilder sourceFile = new StringBuilder();
        InputStream inputStream = shaderUtils.class.getResourceAsStream(filename);
        Exception exception = null;
        BufferedReader reader;

        if (inputStream == null) {
            return "";
        }

        //Reader部分
        try {
            reader = new @NotNull BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            Exception innerException = null;

            try {
                //こいつが本体
                String line;
                while ((line = reader.readLine()) != null) {
                    sourceFile.append(line).append('\n');
                }
                //以下リーダーエラー検出部分
            } catch (Exception exc) {
                exception = exc;
            } finally {
                try {
                    reader.close();
                } catch (Exception exc) {
                    if (innerException == null) {
                        innerException = exc;
                    } else {
                        exc.printStackTrace();
                    }
                }
            }
            if (innerException != null) {
                throw innerException;
            }
        } catch (Exception exc) {
            exception = exc;
        } finally {
            try {
                inputStream.close();
            } catch (Exception exc) {
                if (exception == null) {
                    exception = exc;
                } else {
                    exc.printStackTrace();
                }
            }

            if (exception != null) {
                throw exception;
            }
        }

        return sourceFile.toString();

    }



}
