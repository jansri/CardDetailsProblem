import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		banking[] b = new banking[10];
		String name = new String();
		String cardnum = new String();
		String edate = new String();
		
		int count = 0;
		System.out.println("Enter the number of entries");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s = br.readLine();
		int length = Integer.parseInt(s);
		for (int i = 0; i < length; i++)
		{
			b[i] = new banking();
		}
		//Dynamic input
		/*while(count < length)
		{
			System.out.println("Enter the record-"+count+" -bank name:");
			name = br.readLine();
			b[count].setbName(name);
			System.out.println("Enter the record-"+count+" -card number:");
			cardnum = br.readLine();
			b[count].setcNumber(cardnum);
			System.out.println("Enter the record-"+count+" -expiry date:");
			edate = br.readLine();
			b[count].setexpDate(edate);
			count++;
		}*/
		
		b[0].setbName("HSBC Can");
		b[0].setcNumber("5601-2345-3446-5678");
		b[0].setexpDate("Nov-2017");
		
		b[1].setbName("Royal Bank of Canada");
		b[1].setcNumber("4519-4532-4524-2456");
		b[1].setexpDate("Oct-2017");
		
		b[2].setbName("American Express");
		b[2].setcNumber("3786-7334-8965-345");
		b[2].setexpDate("Dec-2018");

		ArrayList<String> datestring=new ArrayList<String>();
		for(int i = 0; i < length; i++)
		{
			datestring.add(b[i].getexpDate());
		}
		Collections.sort(datestring, Collections.reverseOrder(new Comparator<String>() {
		        DateFormat f = new SimpleDateFormat("MMM-yyyy");
		        @Override
		        public int compare(String o1, String o2) {
		            try {
		                return f.parse(o1).compareTo(f.parse(o2));
		            } catch (ParseException e) {
		                throw new IllegalArgumentException(e);
		            }
		        }
		}));
		System.out.println("BANK NAME" + '\t' +'\t' + "CARD NUMBER" + '\t' + '\t' + '\t' + "EXPIRY DATE");
		System.out.println("---------------------------------------------------------------------------");
		
		for(String ss:datestring)
		{
			//System.out.println(ss);
			for(int k = 0; k < length; k++)
			{
				if( b[k].getexpDate() == ss)
				{
					System.out.println(b[k].getbName() +'\t'+'\t' + b[k].getcNumber() +'\t'+ '\t' + b[k].getexpDate());
				}
			}
		}
		
		System.out.println();
		System.out.println("The masked card numbers are:");
		System.out.println(maskCardNumber(b[0].getcNumber(), "##xx-xxxx-xxxx-xxxx"));
		System.out.println(maskCardNumber(b[1].getcNumber(), "####-xxxx-xxxx-xxxx"));
		System.out.println(maskCardNumber(b[2].getcNumber(), "xxxx-xxxx-xxxx-###"));
	}

	public static String maskCardNumber(String cardNumber, String mask)
	{
	    int index = 0;
	    StringBuilder maskedNumber = new StringBuilder();
	    for (int i = 0; i < mask.length(); i++) {
	        char c = mask.charAt(i);
	        if (c == '#') {
	            maskedNumber.append(cardNumber.charAt(index));
	            index++;
	        } else if (c == 'x'|| c == '-') {
	            maskedNumber.append(c);
	            index++;
	        } else {
	            maskedNumber.append(c);
	        }
	    }
	    return maskedNumber.toString();
	}

}
