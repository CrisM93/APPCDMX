package mx.gob.cdmx.adip.apps.imageappcdmx.model;

public class Test {
    private String titulo;
    private String urlImage;
    private String description;

    public Test(String titulo, String urlImage, String description) {
        this.titulo = titulo;
        this.urlImage = urlImage;
        this.description = description;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
