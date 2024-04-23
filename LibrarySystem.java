public class LibrarySystem {
    private Book[] booklist;
    private static int bookCount = 0;
    private static final int NUM_BOOK = 10;

    public LibrarySystem() {
        this.booklist = new Book[NUM_BOOK];
    }

    public void addBook(Book book) {
        if (bookCount < NUM_BOOK) {
            booklist[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("라이브러리가 가득 차서 책을 더 추가할 수 없습니다.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                
                for (int j = i; j < bookCount - 1; j++) {
                    booklist[j] = booklist[j + 1];
                }
                booklist[bookCount - 1] = null;
                bookCount--;
                System.out.println("Book \"" + title + "\" 도서관에서 삭제됨.");
                return;
            }
        }
        System.out.println("Book \"" + title + "\" 도서관에서 찾을 수 없음.");
    }

    public void borrowBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (booklist[i].isAvailable()) {
                    booklist[i].setAvailable(false);
                    System.out.println("Book \"" + title + "\" 성공적으로 빌렸습니다.");
                } else {
                    System.out.println("Book \"" + title + "\" 대출이 불가능합니다.");
                }
                return;
            }
        }
        System.out.println("Book \"" + title + "\" 도서관에서 찾을 수 없음\r\n"
        		+ ".");
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (!booklist[i].isAvailable()) {
                    booklist[i].setAvailable(true);
                    System.out.println("Book \"" + title + "\" 성공적으로 돌아왔습니다.");
                } else {
                    System.out.println("Book \"" + title + "\" 이미 사용 가능합니다.");
                }
                return;
            }
        }
        System.out.println("Book \"" + title + "\"도서관에서 찾을 수 없음.");
    }

    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            Book book = booklist[i];
            System.out.println(book.getIsbn() + " | " + book.getTitle() + " | " + book.getAuthor() + " | " + book.getYear() + " | " + (book.isAvailable() ? "Available" : "Out"));
        }
    }
}