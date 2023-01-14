package at.ac.campuswien.weatherapp;

public enum Day {
    MONDAY(null), TUESDAY(null), WEDNESDAY(null), THURSDAY(null), FRIDAY(null), SATURDAY(null), SUNDAY(null);

    private String imgPath;

    Day(String path){
        this.imgPath = path;
    }

    public void setImgPath(String path){
        this.imgPath = path;
    }

    public String getImgPath(){
        return this.imgPath;
    }
}
