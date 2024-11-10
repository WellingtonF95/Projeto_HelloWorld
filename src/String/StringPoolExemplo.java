package String;

public class StringPoolExemplo {

    public static void main(String[] args) {

        String meuNome = "Wellington";
        String outroNome = "Wellington";
        String meuNomeDnv = new String("Wellington");

        System.out.println(meuNome == meuNomeDnv);
        System.out.println(meuNome == outroNome);

        System.out.println(1 + 2);
        System.out.println(1 + 2 + "well");
        System.out.println("well" + 1 + 2);
        System.out.println((1 + 2) + "well" +  9 + ("1" + 1));

        int tres = 3;
        String quatro = "4";

        System.out.println(1 + 2 + tres + quatro);

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");
        System.out.println(s2);

    }

}
