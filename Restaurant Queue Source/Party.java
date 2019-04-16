import java.util.Scanner;

public class Party
{

int arrival;
int size;
String name;

//constructor of party object
public Party(Scanner file)
{
    arrival=file.nextInt();
    size= file.nextInt();
    name= file.next();
    name= name + file.nextLine();
}
}