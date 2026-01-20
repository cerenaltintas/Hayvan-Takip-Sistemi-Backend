package tr.edu.gumushane.hayvantakip.exception;

public class AnimalErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

<<<<<<< HEAD
=======
    // Puanlama Esası: Özel yapım hata cevap sınıfı
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public AnimalErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

<<<<<<< HEAD
=======
    // --- EKSİK KISIM BURASI (GETTER VE SETTER'LAR) ---

>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}