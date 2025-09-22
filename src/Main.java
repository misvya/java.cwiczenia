public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int wynik = suma (2, 6);
        System.out.println(wynik);
        przywitajSie("Ania");
        wypiszLiczbyDwucyfroweParzyste();
        System.out.println(sumaLiczbOdADoB(2, 7));
        System.out.println(czyPierwsza(25)); //false
        System.out.println(czyPierwsza(23)); //true
        System.out.println(czyPierwsza(24)); //false

        System.out.println(ileDzielnikowMaLiczba(12)); //6
        System.out.println(ileDzielnikowMaLiczba(1)); //1

        System.out.println(nwd(48, 34)); //2
        System.out.println(nwd(48, 0));// 48
        System.out.println(nwd(0, 10)); //10

        System.out.println(silnia(20));

        //long liczba = 8999999999999999999L;
        //long liczba = 120;
        //int n = 0;
        //while(liczba > 0 ){
            //n++;
        //}
        //System.out.println(n);

        System.out.println(potega(2,3));
        System.out.println(zmienZDziesietnegoNaSystem(6, 2)); //110
        System.out.println(zmienZDziesietnegoNaSystem(171, 16));
    }

    private static int suma(int a, int b){
        return a + b;
    }

    private static void przywitajSie(String imie){
        System.out.println("Dzień dobry " + imie);
    }

    /**
     * wypiszLiczbyDwucyfroweParzyte - wypisuje wszytski liczby parzyste od 10 do 98
     * argumenty brak
     * zwraca wartość brak
     */
    private static void wypiszLiczbyDwucyfroweParzyste(){
        System.out.println("Liczby dwucyfrowe");
        for (int i = 10; i < 100; i+=2){
            System.out.println(i+", ");
        }
    }

    /**
     * sumaLiczbOdADoB - oblicza sume wszytskich liczb calowitych pomiedzy a i b
     * @param a - początek zakresu nazleży dodać sumy
     * @param b - koniec zakresu należy do sumy
     * @return - suma wszystkich liczb od a do b
     */
    private static int sumaLiczbOdADoB(int a, int b){
        int suma = 0;
        if(a > b){

            //a = 2 b = 5
            a = a + b; //7
            b = a - b; //2
            a = a - b; //5
            //b = 2 a = 5
        }
        for(int i = a; i <=b; i++){
            suma+=i;
        }
        return suma;
    }

    /**
     * czyPierwsza - sprawdza czy liczba jest pierwsza
     * @param liczba - liczba całkowita dodatnia dla której spraswdzamy czy jest pierwza
     * @return - zwraca true jeżeli liczba jest liczbą pierwszą, fase w przciwnym przypadku
     */
    private static boolean czyPierwsza(int liczba){
        if(liczba == 1){
            return false;
        }
        int pierwiastek = (int) (Math.sqrt(liczba));
        for (int i = 2; i <= pierwiastek; i++){
            if(liczba % i == 0 ){
                return false;
            }
        }

        return true;
    }

    /**
     * zwraca nwd metodą euklidesa
     * @param a poierwsza liczba >=0
     * @param b druga liczba >=0
     * @return
     */
    private static int nwd(int a, int b){
        while (b != 0){
            int reszta = a % b;
            a = b;
            b = reszta;
        }
        return a;
    }

    /**
     * @param liczba
     * @return
     */
    private static int ileDzielnikowMaLiczba(int liczba){
        int LicznikDzielnikow = 0;
        for (int i = 1; i <= Math.sqrt(liczba); i++) {
            if(liczba % i == 0){
                if(i == liczba / i){
                    LicznikDzielnikow++;
                    break;
                }else{
                    LicznikDzielnikow = LicznikDzielnikow + 2;
                }
            }
        }
        return LicznikDzielnikow;
    }

    /**
     * @param n - liczba całkowita w zakresie od 0 do 20
     * @return siolnia liczby n
     */
    private static long silnia(int n){
        //5! = 1 * 2 * 3 * 4 * 5
        long wynikSilnia = 1;
        for (int i =2; i <= n; i++){
            wynikSilnia *= i;
        }
        return wynikSilnia;
    }

    /**
     * @param podstawa licznik rzeczywista
     * @param wykladnik liczba calkowita dodatnia lub ujemna lub 0
     * @return
     */
    private static double potega(double podstawa, int wykladnik){
        double wynik = 1;
        boolean czyUjemna = false;
        if(wykladnik <0){
            czyUjemna = true;
            wykladnik =- wykladnik;
        }
        for (int i = 0; i <wykladnik; i++){
            wynik = wynik * podstawa;
        }
        if(czyUjemna){
            return 1 / wynik;
        }
        return wynik;
    }

    private static boolean czyPalidrom(String slowo){
        slowo.charAt(0);
        //String jest niemutowalny
        int k = slowo.length()-1;
        for (int i = 0; i < slowo.length() / 2; i++) {
            if(slowo.charAt(i) != slowo.charAt(k)){
                return false;
            }
            k--;
        }
        return true;
    }
    private static String zmienZDziesietnegoNaSystem(int liczba, int system){
        String wynik = " ";
        int cyfra;
        while (liczba > 0){
            cyfra = liczba % system;
            if(cyfra > 9){
                cyfra = cyfra + 55;
                wynik = (char)cyfra + wynik;
            }else{
                wynik = cyfra + wynik;
            }
            liczba = liczba / system;
        }
        return wynik;
    }
}