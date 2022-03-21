package com.example.carfaxdemo.jsondata;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Model {
    @SerializedName("listings")
    @Expose
    private List<Listing> listings = null;

    public List<Listing> getListings() {
        return listings;
    }

    public Model(List<Listing> listings) {
        this.listings = listings;
    }

    //Dealer
    public class Dealer {
        @SerializedName("carfaxId")
        @Expose
        private String carfaxId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("zip")
        @Expose
        private String zip;
        @SerializedName("phone")
        @Expose
        private String phone;


        public String getCarfaxId() {
            return carfaxId;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZip() {
            return zip;
        }

        public String getPhone() {
            return phone;
        }

    }

    //IMAGES
    public class Images {
    @SerializedName("large")
    @Expose
    private List<String> large = null;
    @SerializedName("medium")
    @Expose
    private List<String> medium = null;
    @SerializedName("small")
    @Expose
    private List<String> small = null;

    public List<String> getLarge() {
        return large;
    }

    public List<String> getMedium() {
        return medium;
    }

    public List<String> getSmall() {
        return small;
    }

}
//LISTING
public class Listing {

    @SerializedName("dealer")
    @Expose
    private Dealer dealer;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("trim")
    @Expose
    private String trim;
    @SerializedName("mileage")
    @Expose
    private Integer mileage;
    @SerializedName("currentPrice")
    @Expose
    private Double currentPrice;
    @SerializedName("exteriorColor")
    @Expose
    private String exteriorColor;
    @SerializedName("interiorColor")
    @Expose
    private String interiorColor;
    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("drivetype")
    @Expose
    private String drivetype;
    @SerializedName("transmission")
    @Expose
    private String transmission;
    @SerializedName("bodytype")
    @Expose
    private String bodytype;
    @SerializedName("images")
    @Expose
    private Images images;

    public Dealer getDealer() {
        return dealer;
    }

    public String getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public Integer getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public String getEngine() {
        return engine;
    }

    public String getDrivetype() {
        return drivetype;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodytype() {
        return bodytype;
    }

    public Images getImages() {
        return images;
    }
}
}




////BACKUP BELOW
/*
    //cards data

    //would probably need some way to store specific car info to open its details.
    @SerializedName("images") //has photos of various sizes.
    private Images images;

    @SerializedName("listings")  //info within "listings" YEAR, MAKE, MODEL, TRIM
    private Listing[] listings;

    @SerializedName("currentPrice")
    private Double currentPrice;

    @SerializedName("mileage")
    private Integer mileage;

    @SerializedName("dealer") //has some details like phone# etc.
    private Dealer dealer;


    //extra details data

    @SerializedName("interiorColor")
    private String interiorColor;

    @SerializedName("exteriorColor")
    private String exteriorColor;

    @SerializedName("driveType")
    private String driveType;

    @SerializedName("transmission")
    private String transmission;

    @SerializedName("engine")
    private String engine;

    @SerializedName("bodytype")
    private String bodytype;


    //Getters

    public Listing[] getListings() {
        return listings;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Integer getMileage() {
        return mileage;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public String getDriveType() {
        return driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getEngine() {
        return engine;
    }

    public String getBodytype() {
        return bodytype;
    }


    public Double getPrice() {
        return currentPrice;
    }


    //Constructor
    public Data(Images images, Listing[] listings, Double currentPrice, Integer mileage, Dealer dealer, String interiorColor, String exteriorColor, String driveType, String transmission, String engine, String bodytype) {
        this.images = images;
        this.listings = listings;
        this.currentPrice = currentPrice;
        this.mileage = mileage;
        this.dealer = dealer;
        this.interiorColor = interiorColor;
        this.exteriorColor = exteriorColor;
        this.driveType = driveType;
        this.transmission = transmission;
        this.engine = engine;
        this.bodytype = bodytype;
    }*/
