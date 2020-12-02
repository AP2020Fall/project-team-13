package Plato.View;

import java.util.ArrayList;

public abstract class Page {
    private static ArrayList<Page> seenPages ;
    public abstract Page run();

}
