package Wrappers;

public class ConversaoWrapper {

    public static void main(String[] args) {

        //Conversão de tipos primitivos: uso do casting
        int dias = 1000;
        short dias_short = (short) dias;


        //Conversão de um tipo Wrapper Integer para um tipo primitivo short: métodos de conversão
        Integer diasInteger = Integer.valueOf(100);
        short diasShort = diasInteger.shortValue();
        System.out.println(diasShort);

        //Conversão de um tipo Wrapper Integer para um tipo Wrapper Short: métodos de conversão
        Integer diasInteger2 = Integer.valueOf(101);
        short diasShort2 = Short.valueOf(diasInteger2.shortValue());
        System.out.println(diasShort2);

        //Conversão de um tipo Wrapper Double com precisão de duas casas decimais para um tipo primitivo short *perde as duas casas
        Double valorDouble = Double.valueOf(1100.23);
        short valor_doubleShort = valorDouble.shortValue();
        System.out.println(valor_doubleShort);

        //Conversão de um tipo Wrapper Double com precisao de duas casas decimais para um tipo Wrapper Short *perde as duas casas decimais
        Double valorDouble2 = Double.valueOf(1122.34);
        Short valorDoubleShort = Short.valueOf(valorDouble2.shortValue());
        System.out.println(valorDoubleShort);

        Long valorLong = Long.valueOf(12);
        Float valorFloat = Float.valueOf(12);
        Byte valorByte = Byte.valueOf("127");
        System.out.println("Byte: " + valorByte);

        //Unboxing - Pega o valor do tipo primitivo e "embrulha" para o tipo Wrapper
        //Integer valorUnboxing = Integer.valueOf(30);
        Integer valorUnboxing = 30;
        //Autoboxing - Pega o valor do tipo Wrapper e "desembrulha" para o tipo primitivo
        //Integer valorAutoboxing = valorUnboxing.intValue();
        int valorAutoboxing = valorUnboxing;
    }
}
