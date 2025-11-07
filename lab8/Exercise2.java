package lab8;
import java.util.*;

abstract class Media {
    protected String title;

    public Media(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
    	return "Media" + title;
    }
}

class Book extends Media {
    public Book(String title) {
        super(title);
    }

    @Override
    public String toString() {
    	return title;
    }
}

class Magazine extends Media {
    public Magazine(String title) {
        super(title);
    }

    public String toString() {
    	return title;
    }
}

class Shelf<T extends Media> {
    
	List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public T getItem(int index) {
		return items.get(index);
	}
	
	public void printItems() {
		System.out.println(items);
	}
}

class LibraryUtils {
	
	public static <T extends Media> void displayMediaInfo(Shelf<T> shelf) {
		System.out.println("Displaying shelf contents:");
		shelf.printItems();
	}
	
    public static void copyShelf(Shelf<? extends Media> source, Shelf<? super Media> destination) {
        for (Media item : source.items) {
            destination.addItem(item);    
        }
        System.out.println("Shelf copied successfully!");
    }
	
}

public class Exercise2 {
    public static void main(String[] args) {

    	Shelf<Book> bookShelf = new Shelf<>();
        bookShelf.addItem(new Book("Java Fundamentals"));
        bookShelf.addItem(new Book("Effective Java"));
        bookShelf.addItem(new Book("Clean Code"));
        bookShelf.printItems();
        
        Shelf<Magazine> magazineShelf = new Shelf<>();    
        magazineShelf.addItem(new Magazine("Tech Today"));
        magazineShelf.addItem(new Magazine("Science Monthly"));
        magazineShelf.printItems();
        
        System.out.println(" ");
        LibraryUtils.displayMediaInfo(bookShelf);
        LibraryUtils.displayMediaInfo(magazineShelf);
        
        System.out.println(" ");
        Shelf<Media> mixedShelf = new Shelf<>();
        LibraryUtils.copyShelf(bookShelf, mixedShelf);
        LibraryUtils.copyShelf(magazineShelf, mixedShelf);
        mixedShelf.printItems();
       
    }
}