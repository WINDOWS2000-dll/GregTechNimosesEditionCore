package gtne.api.unification.material;

import com.google.common.base.CaseFormat;
import gregtech.api.unification.Element;

import java.util.*;

public class GTNEElements {

    private static final Map<String, Element> elements = new HashMap<>();

    private GTNEElements() {
    }

    /**
     *var TlMa = Elements.add(144, 233, -1, null, "Terrasteel", "TlMa", false);
     * var If = Elements.add(2147483647, 2147483647, -1, null, "Infinity", "If", false);
     * var MaFe = Elements.add(13, 21, -1, null, "Manasteel", "MaFe", false);
     * var EdFe = Elements.add(32, 64, -1, null, "Thaumium", "EdFe", false);
     * var Ed = Elements.add(666, 666, -1, null, "Void", "Ed", false);
     * var Gaia = Elements.add(233, 377, -1, null, "Gaiaingot", "Gaia", false);
     * var GaiaFe = Elements.add(233, 377, -1, null, "Gaiasteel", "GaiaFe", false);
     * var Dc = Elements.add(700, 900, -1, null, "Draconium", "Dc", false);
     * var DcX = Elements.add(9001, 9001, -1, null, "Draconiumawakened", "DcX", false);
     * var Stone = Elements.add(16, 16, -1, null, "Stoneingot", "Stn", false);
     * var ERROR = Elements.add(2147483647, 2147483647, -1, null, "Antimatter", "ERROR", false);
     * var FATALERROR = Elements.add(2147483647, 2147483647, -1, null, "Strangelet", "FATALERROR", false);
     * var UNKNOWN = Elements.add(666666666, 666666666, -1, null, "Chaoticmetal", "UNKNOWN", false);
     * var Enderium = Elements.add(171, 254, -1, null, "Enderium", "PtPb₃(BeK₄N₅)", false);
     * var LeadPlatinium = Elements.add(160, 242, -1, null, "Leadplatinium", "PtPb₃", false);
     * var Signalum = Elements.add(112, 147, -1, null, "Signalum", "AgCu₃Si(FeS₂)₅(CrAl₂O₃)Hg₃", false);
     * var Shibuichi = Elements.add(76, 99, -1, null, "Shibuichi", "AgCu₃", false);
     * var Lumium = Elements.add(110, 110, -1, null, "Lumium", "Au₂Si(FeS₂)₅(CrAl₂O₃)Hg₃(AgSn₃)₂", false);
     * var TinSilver = Elements.add(97, 128, -1, null, "Tinsilver", "AgSn₃", false);
     * var Astral = Elements.add(240, 240, -1, null, "Astral", "AstFe", false);
     * var InGaAsP = Elements.add(128, 161, -1, null, "Indiumgalliumarsenidephosphide", "InGaAsP", false);
     * var AlGaAs = Elements.add(77, 94, -1, null, "Algaas", "AlGaAs", false);
     * var LiTiO = Elements.add(218, 242, -1, null, "Lithiumtitanate", "Li₄Ti₅O₁₂", false);
     * var LiMnO = Elements.add(85, 96, -1, null, "Lithiummanganeseoxide", "LiMn₂O₄", false);
     * var Hatune = Elements.add(39393939, 39393939, -1, null, "Hatunemiku", "Mikuchaaaaaaaaaaaan", false);
     * var Selenium = Elements.add(34, 45, -1, null, "Selenium", "Se", false);
     * var KClO4 = Elements.add(19+17+32, 20+18+32, -1, null, "Potassiumperchlorate", "KClO₄", false);
     * var HClO4 = Elements.add(1+17+24, 18+24, -1, null, "Perchloricacid", "HClO₄", false);
     * var Br = Elements.add(35, 44, -1, null, "Bromine", "Br", false);
     */

    public static final Element Dc = add(700, 900, -1, null, "Draconium", "Dc", false);
    public static final Element DcX = add(9001, 9001, -1, null, "DraconiumAwakened", "DcX", false);

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
