package gtne.api.unification.material;

import com.google.common.base.CaseFormat;
import gregtech.api.unification.Element;
import scala.xml.Elem;

import java.util.*;

public class GTNEElements {

    private static final Map<String, Element> elements = new HashMap<>();

    private GTNEElements() {
    }

    public static final Element Dc = add(1200, 900, -1, null, "Draconium", "Dc", false);
    public static final Element DcX = add(9001, 9001, -1, null, "DraconiumAwakened", "DcX", false);
    public static final Element HADc = add(2000, 1200, -1, null, "Highly_Active_Draconium", "|DcA|", false);
    public static final Element HADcX = add(16000, 12000, -1, null, "Highly_Active_Awakened_Draconium", "|-DcXa=|", false);
    public static final Element If = add(2097152, 1048576, -1, null, "Infinity", "If", false);
    public static final Element CLS = add(1628, 814, -1, null, "Celestiallium", "Cls", false);
    public static final Element LNT = add(6666, 6666, -1, null, "Lunatium", "Lnt", false);
    public static final Element STL = add(1, 1, -1, null, "Stellarium", "Str", false);
    public static final Element FTL = add(0, 0, -1, null, "Fractallium", "Ftl", false);
    public static final Element ETP = add(0, 0, -1, null, "Entropium", "Etp", false);
    public static final Element SCR = add(777, 777, -1, null, "Sacred_Metal", "Scr", false);
    public static final Element AM = add(0, 0, -1, null, "Antimatter", "ERROR", false);
    public static final Element TS = add(144, 233, -1, null, "Terrasteel", "TlMa", false);
    public static final Element MS = add(13, 21, -1, null, "Manasteel", "MaFe", false);
    public static final Element EL = add(55, 89, -1, null, "Elementium", "Tl(MaFe)", false);
    public static final Element TH = add(66, 44, -1, null, "Thaumium", "EdFe", false);
    public static final Element Vid = add(666, 444, -1, null, "Void", "Vit(Ed)Mtl", false);
    public static final Element SpNt = add(0, 10000, -1, null, "CosmicNeutronium", "SpNt", false);

    public static Element add(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        elements.put(name, element);
        return element;
    }


    public static List<Element> getAllElements() {
        return Collections.unmodifiableList(new ArrayList<>(elements.values()));
    }

    public static Element[] getAllElementsCT() {
        return elements.values().toArray(new Element[0]);
    }

    public static Element get(String name) {
        return elements.get(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name));
    }
}
