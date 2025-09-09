package classes;

public class Bus {
    private int totalSeats;
    private int pricePerSeat;
    private int occupiedSeats;

    // default constructor (bus initially empty)
    public Bus() {
        this.totalSeats = 0;
        this.pricePerSeat = 0;
        this.occupiedSeats = 0;
    }

    // parameterized constructor
    public Bus(int totalSeats, int pricePerSeat) {
        this.totalSeats = Math.max(0, totalSeats);
        this.pricePerSeat = Math.max(0, pricePerSeat);
        this.occupiedSeats = 0; // initially free
    }

    // copy constructor
    public Bus(Bus other) {
        this.totalSeats = other.totalSeats;
        this.pricePerSeat = other.pricePerSeat;
        this.occupiedSeats = other.occupiedSeats;
    }

    // getters and setters
    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = Math.max(0, totalSeats); }

    public int getPricePerSeat() { return pricePerSeat; }
    public void setPricePerSeat(int pricePerSeat) { this.pricePerSeat = Math.max(0, pricePerSeat); }

    public int getOccupiedSeats() { return occupiedSeats; }
    public void setOccupiedSeats(int occupiedSeats) {
        if (occupiedSeats < 0) occupiedSeats = 0;
        if (occupiedSeats > totalSeats) occupiedSeats = totalSeats;
        this.occupiedSeats = occupiedSeats;
    }

    // try to add n passengers; return true if all fit, false otherwise (no partial)
    public boolean addPassengers(int n) {
        if (n < 0) return false;
        if (occupiedSeats + n <= totalSeats) {
            occupiedSeats += n;
            return true;
        }
        return false;
    }

    // number of free seats
    public int freeSeats() {
        return totalSeats - occupiedSeats;
    }

    public boolean isEmpty() { return occupiedSeats == 0; }
    public boolean isFull()  { return occupiedSeats >= totalSeats; }

    // total revenue from occupied seats
    public int totalRevenue() {
        return occupiedSeats * pricePerSeat;
    }

    @Override
    public String toString() {
        return "Bus{seats=" + totalSeats +
               ", price=" + pricePerSeat +
               ", occupied=" + occupiedSeats +
               ", free=" + freeSeats() + "}";
    }
}