package org.idk.instructorcrud.enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hooby;
    @OneToOne(mappedBy="instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;


    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hooby) {
        this.youtubeChannel = youtubeChannel;
        this.hooby = hooby;
    }

    public InstructorDetail(String youtubeChannel, String hooby, Instructor instructor) {
        this.youtubeChannel = youtubeChannel;
        this.hooby = hooby;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHooby() {
        return hooby;
    }

    public void setHooby(String hooby) {
        this.hooby = hooby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hooby='" + hooby + '\'' +
                '}';
    }
}
