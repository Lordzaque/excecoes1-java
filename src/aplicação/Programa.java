package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-OUT data (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a data de update da reserva:");
			System.out.print("Check-in data (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-OUT data (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now) ) {
	            System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras!");			
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in!");
			}
			else {
				
		
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}

}
