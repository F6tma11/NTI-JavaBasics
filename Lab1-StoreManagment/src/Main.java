import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static int productCount=0;
    private static final int MAX_PRODUCTS=100;
    private static ArrayList<Integer> productCodes=new ArrayList<>();
    private static ArrayList<String> productNames=new ArrayList<>();
    private static ArrayList<Double> prices=new ArrayList<>();
    private static ArrayList<Integer> stockQuantities=new ArrayList<>();
    private static ArrayList<Integer> soldQuantities =new ArrayList<>();
    private static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) {
        int i;
        System.out.println("===== STORE MANAGEMENT SYSTEM =====");
        System.out.println("1. Add New Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Sell Product");
        System.out.println("4. Restock Product");
        System.out.println("5. Search Product by Code");
        System.out.println("6. Show Low Stock Alert (quantity < 5)");
        System.out.println("7. Calculate Total Inventory Value");
        System.out.println("8. Show Sales Report");
        System.out.println("9. Show Best Selling Product");
        System.out.println("0. Exit");
        System.out.println("====================================");

        while (true){
            System.out.print("Enter your choice:");
            i=scan.nextInt();
            scan.nextLine();
            if (i==0){
                System.out.println("Program closed.");
                break;
            }
            switch (i){
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    sellProduct();
                    break;
                case 4:
                    restockProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    lowStock();
                    break;
                case 7:
                    sumInventory();
                    break;
                case 8:
                    sumRevenue();
                    break;
                case 9:
                    calcBestSeller();
                    break;
                default:
                    if (i < 0 || i >= 9) System.out.println("Please enter from 1 to 9 or o to exit program");

            }

        }



    }

    public static void addProduct(){

        if(productCount>=MAX_PRODUCTS){
            System.out.println("Error: Store is full! Cannot add more products.");
            return;
        }

        System.out.print("Enter Product code : ");
        int code=scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Product name : ");
        String name=scan.nextLine();
        System.out.print("Enter Product price : ");
        double price = scan.nextDouble();
        scan.nextLine();
        System.out.print("Enter product stock : ");
        int stock=scan.nextInt();
        scan.nextLine();
        System.out.print("Enter product sold : ");
        int sold=scan.nextInt();
        scan.nextLine();

        if(productCodes.contains(code) ){
            System.out.println("Error: Product code already exists!");
            return;
        }
        if(name.isBlank()){
            System.out.println("Error: Product name cannot be empty!");
            return;
        }
        if(price<0){
            System.out.println("Error: Price must be greater than 0!");
            return;
        }
        if(stock<0){
            System.out.println("Error: Stock quantity cannot be negative!");
            return;
        }
        productCodes.add(code);
        productNames.add(name);
        prices.add(price);
        stockQuantities.add(stock);
        soldQuantities.add(sold);
        productCount++;
        System.out.println("Product added.");

    }

    public static void displayProducts(){

        if(productCount==0){
            System.out.println("You do not have products.");
            return;
        }

        System.out.println("================================Product List======================================");
        System.out.println("Num        Code            Name            Price           Stock           Sold");

        for(int i=0;i<productCount;i++){

            System.out.printf("%d-         %d          %s           %.2f           %d             %d%n",
                    i + 1 ,productCodes.get(i),productNames.get(i),prices.get(i)
                    ,stockQuantities.get(i),soldQuantities.get(i)
            );


        }
        System.out.println("============================================================================");
        System.out.println(String.format("Total products : %d %n",productCount));
    }

    public static int searchProduct(){
        System.out.print("Enter product code for search : ");
        int code= scan.nextInt();
        scan.nextLine();
        int index=productCodes.indexOf(code);
        if(index<0){
            System.out.println("Error: Product not found!");
            return -1;
        }
        return index;
    }

    public static void sellProduct(){
        int index=searchProduct();
        if(index <0){
            return;
        }
        System.out.print("Enter number : ");
        int quantity=scan.nextInt();
        scan.nextLine();
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be greater than 0.");
            return;
        }
        if (stockQuantities.get(index)<quantity){
            System.out.printf("Error: Only %d units available in stock!",stockQuantities.get(index));
            return;
        }

        System.out.printf("Unit price : %.2f %n Quantity : %d %n",prices.get(index),quantity);
        System.out.printf("Total price : %.2f  %n",prices.get(index)*quantity);
        stockQuantities.set(index,stockQuantities.get(index)-quantity);
        soldQuantities.set(index,soldQuantities.get(index)+quantity);
    }

    public static void restockProduct(){
        int index =searchProduct();

        if(index<0){
            return;
        }

        System.out.print("Enter quantity to restock : ");
        int quantity=scan.nextInt();
        scan.nextLine();
        if(quantity<0){
            System.out.println("Error: Quantity must be greater than 0.");
            return;
        }
        stockQuantities.set(index,stockQuantities.get(index)+quantity);
        System.out.printf("We restock %s  to %d %n",productNames.get(index),stockQuantities.get(index));
    }

    public static void lowStock(){
        int count=0;
        System.out.println("================================Product List======================================");
        System.out.println("Num        Code            Name            Price           Stock           Sold");
        for(int i=0;i<productCount;i++){
            if(stockQuantities.get(i)>5)continue;
            count++;
            System.out.printf("%d-         %d          %s           %.2f           %d             %d%n",
                    i + 1 ,productCodes.get(i),productNames.get(i),prices.get(i)
                    ,stockQuantities.get(i),soldQuantities.get(i)
            );
        }
        if(count==0){
            System.out.println("All products are well stocked!");
        }else {
            System.out.printf("Total Low Stock Items: %d%n",count);
        }
    }

    public static void sumInventory(){
        double inventoryValue=0;

        for (int i=0;i<productCount;i++){
            inventoryValue+=stockQuantities.get(i)*prices.get(i);
        }
        if (inventoryValue>0){
            System.out.println("Total Inventory : "+inventoryValue);
        }else {
            System.out.println("No products stock in the system.");
        }
    }

    public static void sumRevenue(){
        double revenue=0;
        int totalUnitsSold=0;
        double avgRevenue;
        for (int i=0;i<productCount;i++){
            revenue+=soldQuantities.get(i)*prices.get(i);
            totalUnitsSold+=soldQuantities.get(i);
        }
        if (totalUnitsSold<0){
            System.out.println("No sales recorded yet.");
            return;
        }
        avgRevenue=revenue/totalUnitsSold;
        System.out.printf("Total Units Sold : %d%n",totalUnitsSold);
        System.out.printf("Total Revenue : %.2f%n",revenue);
        System.out.printf("Avg Revenue : %.2f%n",avgRevenue);
    }

    public static void calcBestSeller(){
        int bestItemIndex=0;
        if (productCount==0){
            System.out.println("No products in system.");
        }
        for (int i=0 ; i<productCount ;i++){
            if (soldQuantities.get(i)<soldQuantities.get(i+1)){
                bestItemIndex=i+1;
            }
        }
        System.out.println("======================Best Seller product=======================");
        System.out.println("Num        Code            Name            Price           Stock           Sold");
        System.out.printf("%d-         %d          %s           %.2f           %d             %d%n",
                bestItemIndex + 1 ,productCodes.get(bestItemIndex),productNames.get(bestItemIndex),prices.get(bestItemIndex)
                ,stockQuantities.get(bestItemIndex),soldQuantities.get(bestItemIndex)
        );
    }

}