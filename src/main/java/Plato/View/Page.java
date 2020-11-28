package Plato.View;

import java.util.ArrayList;

public abstract class Page {
    private static ArrayList<Page> seenPages = new ArrayList<Page>();
    abstract Page run();
}
