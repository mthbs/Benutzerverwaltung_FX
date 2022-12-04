package de.crm.entity;


public class Kunde {
    private String id;
    private String vorname;
    private String name;
    private String email;
    private String stadt;

    public Kunde(final String id, final String vorname, final String name, final String email, final String stadt) {
        this.id = id;
        this.vorname = vorname;
        this.name = name;
        this.email = email;
        this.stadt = stadt;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(final String stadt) {
        this.stadt = stadt;
    }
}
