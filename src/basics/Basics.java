package basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Basics {

	public static void main(String[] args) {

		List<Subjects> list = Arrays.asList(new Subjects("a1", "a"), new Subjects("b1", "b"), new Subjects("a2", "a"),
				new Subjects("b2", "b"));

		List<Integer> intArray = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Subjects> filteredList = list.stream().filter(filterPredicate).collect(Collectors.toList());

		int incrementBy2 = incrementByOne.apply(12);

		int incrementBy10 = incrementByTen.apply(incrementBy2);

		Function<Integer, Integer> incrementBy2and10Function = incrementByOne.andThen(incrementByTen);

		writeDivider("combining two functions");

		System.out.println(incrementBy10);

		writeDivider("using compose");

		System.out.println(incrementBy2and10Function.apply(12));

		writeDivider("using incrementByOneAndmultTwo by composing");

		System.out.println(incrementByOneAndmultTwo.apply(1,2));

		writeDivider("lambda Expression");

		filteredList.forEach(System.out::println);

		writeDivider("Streams");

		intArray.stream().map(incrementByOne).forEach(System.out::print);
	}

	static Predicate<Subjects> filterPredicate = value -> "a".equals(value.subType);

	static Function<Integer, Integer> incrementByOne = value -> value + 1;

	static Function<Integer, Integer> incrementByTen = value -> value + 10;

	static BiFunction<Integer, Integer, Integer> incrementByOneAndmultTwo = (numberToIncrement,
			multFactor) -> incrementByOne.apply(numberToIncrement) * multFactor;

	static void writeDivider(String name) {
		System.out.println("-------------------" + name + "-------------------");
	}

	static class Subjects {

		public String subName;
		public String subType;

		public Subjects(String subName, String subType) {
			super();
			this.subName = subName;
			this.subType = subType;
		}

		public String getSubName() {
			return subName;
		}

		public void setSubName(String subName) {
			this.subName = subName;
		}

		public String getSubType() {
			return subType;
		}

		public void setSubType(String subType) {
			this.subType = subType;
		}

		@Override
		public String toString() {
			return "Subjects [subName=" + subName + ", subType=" + subType + "]";
		}

	}
}
