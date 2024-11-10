package Wrappers.Exercicio_Wrappers;

public class TelevisorMain {

    public static void main(String[] args) {

        Televisor tv = new Televisor();
        Televisor tv2 = new Televisor(130, 20);
        Radio radio = new Radio("FM", 20);
        Radio radio2 = new Radio(null, 20);

        System.out.println(tv);
        System.out.println(tv2);
        System.out.println(tv2.equals(tv));
        System.out.println(radio.equals(radio2));

        //Não deveria mudar o volume e canal
        tv.mudarVolume(20);
        tv.mudarCanal(130);

        //Deveria mudar o volume e canal
        tv.mudarVolume(300);
        tv.mudarCanal(10);

        String BASIC = "Basic ";
        String token = "123ghj5";
        System.out.println(BASIC.concat(token));

    }
}
