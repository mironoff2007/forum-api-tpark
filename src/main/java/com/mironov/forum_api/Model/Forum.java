package com.mironov.forum_api.Model;

/*
*description:
Информация о форуме.

posts:	number ($int64)
readOnly: true
example: 200000
Общее кол-во сообщений в данном форуме.

slug:	string *($identity)
pattern: ^(\d|\w|-|_)*(\w|-|_)(\d|\w|-|_)*$
x-isnullable: false
example: pirate-stories
Человекопонятный URL (https://ru.wikipedia.org/wiki/%D0%A1%D0%B5%D0%BC%D0%B0%D0%BD%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_URL), уникальное поле.

threads:	number ($int32)
readOnly: true
example: 200
Общее кол-во ветвей обсуждения в данном форуме.

title:	string *
x-isnullable: false
example: Pirate stories
Название форума.

user:	string *($identity)
x-isnullable: false
example: j.sparrow
Nickname пользователя, который отвечает за форум.*/
public class Forum {

    private int posts;

    private String slugs;

    private String title;

    private String user;

    public Forum(int posts, String slugs, String title, String user) {
        this.posts = posts;
        this.slugs = slugs;
        this.title = title;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "posts=" + posts +
                ", slugs='" + slugs + '\'' +
                ", title='" + title + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
