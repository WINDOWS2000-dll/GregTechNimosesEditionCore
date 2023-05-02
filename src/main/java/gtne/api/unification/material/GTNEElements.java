package gtne.api.unification.material;

import com.google.common.base.CaseFormat;
import gregtech.api.unification.Element;

import java.util.*;

public class GTNEElements {

    private static final Map<String, Element> elements = new HashMap<>();

    private GTNEElements() {
    }

    public static final Element Dc = add(1200, 900, -1, null, "Draconium", "Dc", false);
    public static final Element DcX = add(9001, 9001, -1, null, "DraconiumAwakened", "DcX", false);
    public static final Element HADc = add(2000, 1200, -1, null, "Highly_Active_Draconium", "|DcA|", false);
    public static final Element HADcX = add(16000, 12000, -1, null, "Highly_Active_Awakened_Draconium", "|-DcXa=|", false);

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
