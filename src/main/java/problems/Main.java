package problems;

public class Main {
    public static void main(String[] args){
        Floor floor = new FloorBinarySearchImpl();

        Integer[] arrayPar = {1,2,3,5,6,7,8};
        Integer[] arrayImpar = {1,2,3,5,6,7,8,9};

        /**
         * Valor abaixo
         */
        System.out.println(floor.floor(arrayPar, 4));
        System.out.println(floor.floor(arrayImpar, 4));

        /**
         * Valor igual
         */
        System.out.println(floor.floor(arrayPar, 5));
        System.out.println(floor.floor(arrayImpar, 5));

        /**
         * Valor extremos
         */
        System.out.println(floor.floor(arrayPar, 1));
        System.out.println(floor.floor(arrayPar, 8));
        System.out.println(floor.floor(arrayImpar, 1));
        System.out.println(floor.floor(arrayImpar, 9));

        /**
         * Valor null
         */
        System.out.println(floor.floor(arrayPar, 0));
        System.out.println(floor.floor(arrayImpar, 0));

        /**
         * Valor maior que os extremos
         */
        System.out.println(floor.floor(arrayPar, 20));
        System.out.println(floor.floor(arrayImpar, 20));
    }
}
