import java.util.Random;
import java.util.Scanner;

class Customer {
    String name;
    long phno;
    String add;
    int age;
    String email;
    int roomno;
    String cin;
    String cout;
    String rt;
    int rr;
    String days;
    int restaurant_charges;
    int laundry_charges;
    int gaming_charges;
}

public class HotelManagement {
    static Customer[] d = new Customer[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("1. Booking");
            System.out.println("2. Rooms Info");
            System.out.println("3. Restaurant");
            System.out.println("4. Laundry");
            System.out.println("5. Game");
            System.out.println("6. Payment");
            System.out.println("7. Exit");
            System.out.print("-> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Booking(scanner, random);
                    break;
                case 2:
                    Rooms_Info();
                    break;
                case 3:
                    restaurant(scanner);
                    break;
                case 4:
                    Laundry(scanner);
                    break;
                case 5:
                    Game(scanner);
                    break;
                case 6:
                    Payment(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void Booking(Scanner scanner, Random random) {
        d[count] = new Customer();

        System.out.print("Enter your Name: ");
        d[count].name = scanner.nextLine();

        while (true) {
            System.out.print("Enter your phone number: ");
            d[count].phno = scanner.nextLong();
            scanner.nextLine();
            if (d[count].phno >= 1000000000L && d[count].phno <= 9999999999L) {
                break;
            } else {
                System.out.println("Invalid phone number!! Try again!\n");
            }
        }

        System.out.print("Enter your Address: ");
        d[count].add = scanner.nextLine();

        System.out.print("Enter your Age: ");
        d[count].age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your Email id: ");
        d[count].email = scanner.nextLine();

        System.out.print("Enter check in date(in dd/mm/yyyy): ");
        d[count].cin = scanner.nextLine();

        System.out.print("Enter check out date(in dd/mm/yyyy): ");
        d[count].cout = scanner.nextLine();

        int days;
        if (Integer.parseInt(d[count].cout.substring(3, 5)) > Integer.parseInt(d[count].cin.substring(3, 5))) {
            if (d[count].cin.substring(3, 5).equals("01") || d[count].cin.substring(3, 5).equals("03") || d[count].cin.substring(3, 5).equals("05") || d[count].cin.substring(3, 5).equals("07") || d[count].cin.substring(3, 5).equals("08") || d[count].cin.substring(3, 5).equals("10") || d[count].cin.substring(3, 5).equals("12")) {
                days = (31 - Integer.parseInt(d[count].cin.substring(0, 2))) + Integer.parseInt(d[count].cout.substring(0, 2));
            } else {
                days = (30 - Integer.parseInt(d[count].cin.substring(0, 2))) + Integer.parseInt(d[count].cout.substring(0, 2));
            }
        } else {
            days = Integer.parseInt(d[count].cout.substring(0, 2)) - Integer.parseInt(d[count].cin.substring(0, 2));
        }
        d[count].days = days + " days";

        System.out.println("----SELECT ROOM TYPE----\n 1. Standard Non-AC\n 2. Standard AC\n 3. 3-Bed Non-AC\n 4. 3-Bed AC\n Press 0 for Room Prices\n");
        System.out.print("-> ");
        int rc = scanner.nextInt();
        scanner.nextLine();

        if (rc == 0) {
            System.out.println("\n 1. Standard Non-AC - Rs. 3500\n 2. Standard AC - Rs. 4000\n 3. 3-Bed Non-AC - Rs. 4500\n 4. 3-Bed AC - Rs. 5000\n");
            System.out.print("-> ");
            rc = scanner.nextInt();
            scanner.nextLine();
        }

        if (rc == 1) {
            d[count].rt = "Standard Non-AC";
            System.out.println("Room Type- Standard Non-AC\n");
            d[count].rr = 3500 * days;
            System.out.println("Price- 3500 , Total price = " + d[count].rr);
        } else if (rc == 2) {
            d[count].rt = "Standard AC";
            System.out.println("Room Type- Standard AC\n");
            d[count].rr = 4000 * days;
            System.out.println("Price- 4000 , Total price = " + d[count].rr);
        } else if (rc == 3) {
            d[count].rt = "3-Bed Non-AC";
            System.out.println("Room Type- 3-Bed Non-AC\n");
            d[count].rr = 4500 * days;
            System.out.println("Price- 4500 , Total price = " + d[count].rr);
        } else if (rc == 4) {
            d[count].rt = "3-Bed AC";
            System.out.println("Room Type- 3-Bed AC\n");
            d[count].rr = 5000 * days;
            System.out.println("Price- 5000 , Total price = " + d[count].rr);
        } else {
            System.out.println("Wrong choice..!!\n");
        }

        while (true) {
            if (rc == 1) {
                d[count].roomno = random.nextInt(51) + 100;
            } else if (rc == 2) {
                d[count].roomno = random.nextInt(51) + 150;
            } else if (rc == 3) {
                d[count].roomno = random.nextInt(51) + 200;
            } else if (rc == 4) {
                d[count].roomno = random.nextInt(51) + 250;
            }
            boolean flag = false;
            for (int i = 0; i < count; i++) {
                if (d[count].roomno == d[i].phno) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println("Successfully Booked for " + d[count].days);
        System.out.println("Your room no. and customer id is " + d[count].roomno + "\n\n");
        count++;
    }

    static void Rooms_Info() {
        System.out.println(" ------ HOTEL ROOMS INFO -----\n ");
        System.out.println("\n1.STANDARD NON-AC\n");
        System.out.println("--------------------------------------------------------------- \n");
        System.out.println("ROOM AMENITIES INCLUDE: \n");
        System.out.println("1 Double Bed\n");
        System.out.println("Television\n");
        System.out.println("Telephone \n");
        System.out.println("Double-Door Cupboard\n");
        System.out.println("1 Coffee table with 2 sofa\n");
        System.out.println("Balcony\n");
        System.out.println("an attached washroom with hot/cold water.\n");

        System.out.println("\n2.STANDARD AC\n");
        System.out.println("--------------------------------------------------------------- \n");
        System.out.println("ROOM AMENITIES INCLUDE: \n");
        System.out.println("1 Double Bed\n");
        System.out.println("Television\n");
        System.out.println("Telephone\n");
        System.out.println("Double-Door Cupboard\n");
        System.out.println("1 Coffee table with 2 sofa Balcony\n");
        System.out.println("an attached washroom with hot/cold water + Window/Split AC.\n");

        System.out.println("\n3.3-BED NON-AC \n");
        System.out.println("--------------------------------------------------------------- \n");
        System.out.println("ROOM AMENITIES INCLUDE: \n");
        System.out.println("1 Double Bed + 1 Single Bed\n");
        System.out.println("Television\n");
        System.out.println("Telephone\n");
        System.out.println("a Triple-Door Cupboard\n");
        System.out.println("1 Coffee table with 2 sofa\n");
        System.out.println("Side table\n");
        System.out.println("Balcony with an Accent table with 2 Chair\n");
        System.out.println("an attached washroom with hot/cold water.\n");

        System.out.println("\n4.3-BED AC \n");
        System.out.println("--------------------------------------------------------------- \n");
        System.out.println("ROOM AMENITIES INCLUDE: \n");
        System.out.println("1 Double Bed + 1 Single Bed\n");
        System.out.println("Television\n");
        System.out.println("Telephonev");
        System.out.println("a Triple-Door Cupboard\n");
        System.out.println("1 Coffee table with 2 sofa \n");
        System.out.println("1 Side table\n");
        System.out.println("Balcony with an Accent table with 2 Chair  \n");
        System.out.println("an attached washroom with hot/cold water + Window/Split AC.\n\n");
    }

    static void restaurant(Scanner scanner) {
        System.out.print("Customer Id: ");
        int cs = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (cs == d[i].roomno) {
                flag = true;
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                           HOTEL ROYAL GALAXY                            \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                            Menu Card                                    \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("\n BEVERAGES                            26 Dal Fry................ 140.00\n");
                System.out.println("----------------------------------      27 Dal Makhani............ 150.00\n");
                System.out.println(" 1  Regular Tea............. 20.00      28 Dal Tadka.............. 150.00\n");
                System.out.println(" 2  Masala Tea.............. 25.00                                       \n");
                System.out.println(" 3  Coffee.................. 25.00      ROTI                             \n");
                System.out.println(" 4  Cold Drink.............. 25.00     ----------------------------------\n");
                System.out.println(" 5  Bread Butter............ 30.00      29 Plain Roti.............. 15.00\n");
                System.out.println(" 6  Bread Jam............... 30.00      30 Butter Roti............. 15.00\n");
                System.out.println(" 7  Veg. Sandwich........... 50.00      31 Tandoori Roti........... 20.00\n");
                System.out.println(" 8  Veg. Toast Sandwich..... 50.00      32 Butter Naan............. 20.00\n");
                System.out.println(" 9  Cheese Toast Sandwich... 70.00                                       \n");
                System.out.println(" 10 Grilled Sandwich........ 70.00      RICE                             \n");
                System.out.println("                                       ----------------------------------\n");
                System.out.println(" SOUPS                                  33 Plain Rice.............. 90.00\n");
                System.out.println("----------------------------------      34 Jeera Rice.............. 90.00\n");
                System.out.println(" 11 Tomato Soup............ 110.00      35 Veg Pulao.............. 110.00\n");
                System.out.println(" 12 Hot & Sour............. 110.00      36 Peas Pulao............. 110.00\n");
                System.out.println(" 13 Veg. Noodle Soup....... 110.00                                       \n");
                System.out.println(" 14 Sweet Corn............. 110.00      SOUTH INDIAN                     \n");
                System.out.println(" 15 Veg. Munchow........... 110.00     ----------------------------------\n");
                System.out.println("                                        37 Plain Dosa............. 100.00\n");
                System.out.println(" MAIN COURSE                            38 Onion Dosa............. 110.00\n");
                System.out.println("----------------------------------      39 Masala Dosa............ 130.00\n");
                System.out.println(" 16 Shahi Paneer........... 110.00      40 Paneer Dosa............ 130.00\n");
                System.out.println(" 17 Kadai Paneer........... 110.00      41 Rice Idli.............. 130.00\n");
                System.out.println(" 18 Handi Paneer........... 120.00      42 Sambhar Vada........... 140.00\n");
                System.out.println(" 19 Palak Paneer........... 120.00                                       \n");
                System.out.println(" 20 Chilli Paneer.......... 140.00      ICE CREAM                        \n");
                System.out.println(" 21 Matar Mushroom......... 140.00     ----------------------------------\n");
                System.out.println(" 22 Mix Veg................ 140.00      43 Vanilla................. 60.00\n");
                System.out.println(" 23 Jeera Aloo............. 140.00      44 Strawberry.............. 60.00\n");
                System.out.println(" 24 Malai Kofta............ 140.00      45 Pineapple............... 60.00\n");
                System.out.println(" 25 Aloo Matar............. 140.00      46 Butter Scotch........... 60.00\n");
                System.out.println("Press 0 -to end \n");
                System.out.println("\n");
                int ch, q;
                int r = 0;
                while (true) {
                    System.out.print(" Product no.-> ");
                    ch = scanner.nextInt();
                    System.out.print(" Quantity-> ");
                    q = scanner.nextInt();
                    if (ch == 1 || ch == 31 || ch == 32) {
                        r += 20 * q;
                    } else if (ch >= 2 && ch <= 4) {
                        r += 25 * q;
                    } else if (ch >= 5 && ch <= 6) {
                        r += 30 * q;
                    } else if (ch >= 7 && ch <= 8) {
                        r += 50 * q;
                    } else if (ch >= 9 && ch <= 10) {
                        r += 70 * q;
                    } else if ((ch >= 11 && ch <= 17) || ch == 35 || ch == 36 || ch == 38) {
                        r += 110 * q;
                    } else if (ch == 18 || ch == 19) {
                        r += 120 * q;
                    } else if (ch >= 20 && ch <= 26 || ch == 42) {
                        r += 140 * q;
                    } else if (ch >= 27 && ch <= 28) {
                        r += 150 * q;
                    } else if (ch >= 29 && ch <= 30) {
                        r += 15 * q;
                    } else if (ch == 33 || ch == 34) {
                        r += 90 * q;
                    } else if (ch == 37) {
                        r += 100 * q;
                    } else if (ch >= 39 && ch <= 41) {
                        r += 130 * q;
                    } else if (ch >= 43 && ch <= 46) {
                        r += 60 * q;
                    } else if (ch == 0) {
                        break;
                    } else {
                        System.out.println("Wrong Choice..!!\n");
                    }
                }
                System.out.println("\nTotal Restaurant Bill: " + r);
                d[i].restaurant_charges = r;
                break;
            }
        }
        if (!flag) {
            System.out.println("Invalid Customer Id\n");
            System.out.print("Customer Id: ");
            cs = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("\n");
    }

    static void Laundry(Scanner scanner) {
        System.out.print("Customer Id: ");
        int cs = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (cs == d[i].roomno) {
                flag = true;
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                           HOTEL ROYAL GALAXY                            \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                            Laundry Card                                 \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("1. TIE                                                             Rs.20 \n");
                System.out.println("2. SOCKS(PAIR)                                                     Rs.20 \n");
                System.out.println("3. TOWEL/HANDKERCHIEF                                              Rs.20 \n");
                System.out.println("4. SHIRT                                                           Rs.40 \n");
                System.out.println("5. T-SHIRT                                                         Rs.40 \n");
                System.out.println("6. JEANS                                                           Rs.40 \n");
                System.out.println("7. SKIRTS                                                          Rs.40 \n");
                System.out.println("8. PANTS/TROUSER/PALLAZO                                           Rs.40 \n");
                System.out.println("9. SHORTS/BERMUDA                                                  Rs.40 \n");
                System.out.println("10.GYM CLOTHES                                                     Rs.50 \n");
                System.out.println("11.SWIMSUIT                                                        Rs.50 \n");
                System.out.println("12.BATHROBE                                                        Rs.50 \n");
                System.out.println("13.HOODIES/SWEATSHIRT/SWEATERS                                     Rs.80 \n");
                System.out.println("14.COAT                                                            Rs.80 \n");
                System.out.println("15.SAREE                                                           Rs.80 \n");
                System.out.println("16.KURTI                                                           Rs.80 \n");
                System.out.println("17.NIGHT DRESS                                                     Rs.80 \n");
                System.out.println("18.WEDDING DRESSES                                                 Rs.250\n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("Press 0 -to end \n");
                System.out.println("\n");
                int ch, q;
                int l = 0;
                while (true) {
                    System.out.print(" Product no.-> ");
                    ch = scanner.nextInt();
                    System.out.print(" Quantity-> ");
                    q = scanner.nextInt();
                    if (ch >= 1 && ch <= 3) {
                        l += 20 * q;
                    } else if (ch >= 4 && ch <= 9) {
                        l += 40 * q;
                    } else if (ch >= 10 && ch <= 12) {
                        l += 50 * q;
                    } else if (ch >= 13 && ch <= 17) {
                        l += 80 * q;
                    } else if (ch == 18) {
                        l += 250 * q;
                    } else if (ch == 0) {
                        break;
                    } else {
                        System.out.println("Wrong Choice..!!\n");
                    }
                }
                System.out.println("\nTotal Laundry Bill: " + l);
                d[i].laundry_charges = l;
                break;
            }
        }
        if (!flag) {
            System.out.println("Invalid Customer Id\n");
            System.out.print("Customer Id: ");
            cs = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("\n");
    }

    static void Game(Scanner scanner) {
        System.out.print("Customer Id: ");
        int cs = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (cs == d[i].roomno) {
                flag = true;
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                           HOTEL ROYAL GALAXY                            \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("                              GAME ZONE                                  \n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("1. TABLE TENNIS ------------------------------------------------Rs.150/hr\n");
                System.out.println("2. BOWLING -----------------------------------------------------Rs.100/hr\n");
                System.out.println("3. SNOOKER -----------------------------------------------------Rs.250/hr\n");
                System.out.println("4. VR WORLD GAMING----------------------------------------------Rs.400/hr\n");
                System.out.println("5. VIDEO GAMES -------------------------------------------------Rs.300/hr\n");
                System.out.println("6. SWIMMING POOL GAMES -----------------------------------------Rs.350/hr\n");
                System.out.println("-------------------------------------------------------------------------\n");
                System.out.println("Press 0 -to end \n");
                System.out.println("\n");
                int game, hour;
                int g = 0;
                while (true) {
                    System.out.print("Enter What Game You Want To Play : ");
                    game = scanner.nextInt();
                    System.out.print("Enter No Of Hours You Want To Play : ");
                    hour = scanner.nextInt();
                    if (game == 1) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : Table Tennis\n");
                        g += hour * 150;
                    } else if (game == 2) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : Bowling\n");
                        g += hour * 100;
                    } else if (game == 3) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : Snooker\n");
                        g += hour * 250;
                    } else if (game == 4) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : VR World Gaming\n");
                        g += hour * 400;
                    } else if (game == 5) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : Video Games\n");
                        g += hour * 300;
                    } else if (game == 6) {
                        System.out.println("YOU HAVE SELECTED TO PLAY : Swimming Pool Games\n");
                        g += hour * 350;
                    } else if (game == 0) {
                        break;
                    } else {
                        System.out.println("Wrong Choice..!!\n");
                    }
                }
                System.out.println("\nTotal Game Zone Bill: " + g + "\n\n");
                d[i].gaming_charges = g;
                break;
            }
        }
        if (!flag) {
            System.out.println("Invalid Customer Id\n");
            System.out.print("Customer Id: ");
            cs = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("\n");
    }

    static void Payment(Scanner scanner) {
        System.out.print("Enter your phone number: ");
        int ph = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your customer ID: ");
        int custid = scanner.nextInt();
        scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (d[i].phno == ph) {
                flag = true;
                System.out.println(" Payment\n");
                System.out.println(" --------------------------------\n");
                System.out.println("  MODE OF PAYMENT                \n");
                System.out.println("  1- Credit/Debit Card           \n");
                System.out.println("  2- Paytm/PhonePe               \n");
                System.out.println("  3- Using UPI                   \n");
                System.out.println("  4- Cash                        \n");
                System.out.print("-> ");
                int x = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\n  Amount: " + (d[i].rr + d[i].gaming_charges + d[i].restaurant_charges + d[i].laundry_charges));
                System.out.println("\n Pay For Royal Galaxy\n");
                System.out.println("  (y/n)\n");
                String ch = scanner.nextLine();
                if (ch.equalsIgnoreCase("y")) {
                    System.out.println("\n\n --------------------------------\n");
                    System.out.println("           HOTEL ROYAL GALAXY        \n");
                    System.out.println(" ------------------------------------\n");
                    System.out.println("              Bill                   \n");
                    System.out.println(" ------------------------------------\n");
                    System.out.println(" Name: " + d[i].name + "\t\n Phone No.: " + d[i].phno + "\t\n Address: " + d[i].add + "\t\n");
                    System.out.println("\n Check-In: " + d[i].cin + "\t\n Check-Out: " + d[i].cout + "\t\n");
                    System.out.println("\n Room Type: " + d[i].rt + "\t\n Room Charges: " + d[i].rr + "\t\n");
                    System.out.println(" Restaurant Charges: \t" + d[i].restaurant_charges + "\n");
                    System.out.println(" Laundry Charges: \t" + d[i].laundry_charges + "\n");
                    System.out.println(" Gaming Charges: \t" + d[i].gaming_charges + "\n");
                    System.out.println(" -----------------------------------\n");
                    System.out.println("\n Total Amount: " + (d[i].rr + d[i].gaming_charges + d[i].restaurant_charges + d[i].laundry_charges) + "\t\n");
                    System.out.println(" -----------------------------------\n");
                    System.out.println("          Thank You                 \n");
                    System.out.println("          Visit Again :)            \n");
                    System.out.println(" ---------------------------------\n");
                } else {
                    System.out.println("THERE IS NO BOOKING WITH THIS CONTACT!! OR PAYMENT ALREADY MADE!!\n");
                }
                for (int j = i; j < count - 1; j++) {
                    d[j] = d[j + 1];
                }
                count--;
                break;
            }
        }
        if (!flag) {
            System.out.println("THERE IS NO BOOKING WITH THIS CONTACT!! OR PAYMENT ALREADY MADE!!\n");
        }
        System.out.println("\n");
    }
}
