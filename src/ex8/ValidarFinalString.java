package ex8;

public class ValidarFinalString {
    public boolean verificarCaracteres (String entrada1,String entrada2){
        boolean resultCaractere = true;
        String ultimosCaracteres = entrada1.substring(entrada1.length() -2);
        String primeirosCaracteres = entrada2.substring(0,2);
        if (ultimosCaracteres.isBlank() || ultimosCaracteres.isEmpty() || ultimosCaracteres.length()<2){
            throw new IllegalArgumentException("String possui menos de 2 caracteres");
        }
        if (primeirosCaracteres.isBlank() || primeirosCaracteres.isEmpty() || primeirosCaracteres.length()<2){
            throw new IllegalArgumentException("String possui menos de 2 caracteres");
        }

        if (ultimosCaracteres.equalsIgnoreCase(primeirosCaracteres)){
            resultCaractere = true;
        }
        else {
            resultCaractere = false;
        }

        return resultCaractere;
    }

    public static void main(String[] args) {
        ValidarFinalString validarFinalString = new ValidarFinalString();
        String entrada1  = "programação";
        String entrada2 = "ã0";

        try{
            boolean result = validarFinalString.verificarCaracteres(entrada1,entrada2);
            System.out.println(result);;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
