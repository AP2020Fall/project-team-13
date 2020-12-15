package Plato.View;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Page {
    protected static Scanner scanner = new Scanner(System.in);
    protected static ArrayList<Page> seenPages = new ArrayList<Page>() ;
    public abstract Page run();

}
