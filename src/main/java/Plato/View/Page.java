package Plato.View;

import java.util.ArrayList;

public abstract class Page {
    private static ArrayList<Page> seenPages ;
    protected abstract Page run();

}
