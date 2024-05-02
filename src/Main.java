
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Kullanıcıdan mesafe , yaş ve yolculuk tipi bilgilerini alıyoruz.
        System.out.print("Mesafeyi km türünden giriniz: ");
        int mesafe = sc.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        int yas = sc.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
        int yolculukTipi = sc.nextInt();

        //Veri girişi kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
        } else {
            //Normal ücret hesaplama
            double normalTutar = mesafe * 0.10;

            //Yaş indirimi hesaplama
            double yasIndirimOrani = 0;
            if (yas < 12) {
                yasIndirimOrani = 0.50; // %50 indirim 12 yaşından küçükler için
            } else if (yas >= 12 && yas <= 24) {
                yasIndirimOrani = 0.10; // %10 indirim 12-24 yaş aralığındakiler için
            } else if (yas >= 65) {
                yasIndirimOrani = 0.30; // %30 indirim 65 yaş ve üstündekiler için
            }

            double yasIndirimi = normalTutar * yasIndirimOrani;

            //İndirimli tutar hesaplama
            double indirimliTutar = normalTutar - yasIndirimi;

            //Gidiş dönüş indirimi hesaplama
            double gidisDonusIndirimi = 0;
            if (yolculukTipi == 2) {
                gidisDonusIndirimi = indirimliTutar * 0.20; // %20 indirim gidiş dönüş için
            }

            //Toplam tutar hesaplama
            double toplamTutar = indirimliTutar - gidisDonusIndirimi;
            if (yolculukTipi == 2) {
                toplamTutar *= 2; // Gidiş dönüşse toplam tutarı 2'ye çarp
            }
            //Sonucu ekrana yazdırma
            System.out.println("Toplam Tutar: " + toplamTutar + " TL");
        }

        //Scanner komutunu kapatalım.

        sc.close();
    }
}

