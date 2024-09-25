package collectionWithConstructor;

import java.util.Iterator;
import java.util.List;

public class question {

		public int id;
		public String name;
		public List<String> answers;
		
		public question() {
			
		}
		
		public question(int id, String name, List<String> answers) {
			super();
			this.id = id;
			this.name = name;
			this.answers = answers;
		}


		public void displayInfo() {
			System.out.println(id + " " +name);
			System.out.println(" answers are : ");
			Iterator<String> itr=answers.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
		
}
