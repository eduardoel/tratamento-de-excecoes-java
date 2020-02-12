package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNunmber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNunmber, Date checkIn, Date checkOut) {
        this.roomNunmber = roomNunmber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNunmber() {
        return roomNunmber;
    }

    public void setRoomNunmber(Integer roomNunmber) {
        this.roomNunmber = roomNunmber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future detes!";
        }
        if (!checkOut.after(checkIn)) {
            return "Error in reservation: Check-out date must be after check-in date!";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room"
                + roomNunmber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}
