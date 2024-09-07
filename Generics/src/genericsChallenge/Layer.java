package genericsChallenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> { // I need to do is make this generic, so I'll add a type parameter, and you might remember
                                    // from the requirements that this class should only take Mappable types. In angle brackets I'll
                                    // add T as the type and extends Mappable after that. This sets an upper bound, meaning anything that
                                    // is Mappable can use this Layer class. It also means we can use methods on Mappable without casting.

    private List<T> layerElements;

    public Layer(T[] layerElements) { // why array here? >>>
                                    // >>> so I could instantiate the Layer with the array of Parks or Rivers
        this.layerElements = new ArrayList<T>(List.of(layerElements));
    }

    public void addElements(T... elements) {  // using addElements(T... elements) allows to pass one or multiple locations
        layerElements.addAll(List.of(elements)); // adding Mappable element(s) to the layerElements
    }

    public void renderLayer() {
        for (T element : layerElements) {
            element.render(); // using Point's (Park) and Line's (River) render() methods
        }
    }
}
