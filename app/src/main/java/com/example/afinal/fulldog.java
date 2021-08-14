package com.example.afinal;

public class fulldog {
    image image;
    String name;
    String origin;
    String temperament;
    measure weight;
    measure height;
    String life_span;
    int id;
    public fulldog(String name,image image,String origin,String temperament,measure weight,measure height,int id,String life)
    {
    this.image=image;
    this.name=name;
    this.origin=origin;
    this.temperament=temperament;
    this.weight=weight;
    this.height=height;
    this.id=id;
    this.life_span=life;
    }

}

class measure{
    String imperial;
    String metric;
    public measure(String imperial,String metric)
    {
        this.imperial=imperial;
        this.metric=metric;
    }
}
/* {
    "bred_for": "Small rodent hunting, lapdog",
    "breed_group": "Toy",
    "height": {
      "imperial": "9 - 11.5",
      "metric": "23 - 29"
    },
    "id": 1,
    "image": {
      "height": 1199,
      "id": "BJa4kxc4X",
      "url": "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg",
      "width": 1600
    },
    "life_span": "10 - 12 years",
    "name": "Affenpinscher",
    "origin": "Germany, France",
    "reference_image_id": "BJa4kxc4X",
    "temperament": "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving",
    "weight": {
      "imperial": "6 - 13",
      "metric": "3 - 6"
    }
  }*/