package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a data de update da reserva:");
			System.out.print("Check-in data (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Data invalida");
		} catch (DomainException e) {
			System.out.println("Erro na resarva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

		sc.close();
	}

}
