package ru.home.echo.entity;


import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Books {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookIdGen")
@SequenceGenerator(name = "bookIdGen", sequenceName = "BOOKSEQ",allocationSize = 1)

long id;

@Column(name = "NAME")
String name;

@Column(name = "AUTHOR")
String author;

@Column(name = "YEAR")
int year;


    public Books() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
