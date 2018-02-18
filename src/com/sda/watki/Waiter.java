package com.sda.watki;

public class Waiter implements Runnable{

    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (message){
            try{

                System.out.println("Watek o nazwie" +
                name + " zostal powiadomiony o godzinie: "+
                System.currentTimeMillis());
                message.wait();

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Obiekt Waiter otrzymal" +
                    " notyfikacje: " + System.currentTimeMillis());
            System.out.println("Wiadomosc: " + message.getMessage());
        }

    }
}
