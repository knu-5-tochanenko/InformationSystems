# Recipe Finder

An app to find recipes and save them for later!

# Backend

Backend was developed using Spring and Kotlin. It's deployed on Heroku.

## Endpoints:

**Get 10 random recipes**

```
https://glacial-lake-83393.herokuapp.com/recipe?number=10&offset=0
```

**Get details for recipe by id**
```
https://glacial-lake-83393.herokuapp.com/recipe/716426
```

**Get similar recipes for recipy by id**
```
https://glacial-lake-83393.herokuapp.com/recipe/similar/716426?number=10
```

**Get recipes by ingredients**
```
https://glacial-lake-83393.herokuapp.com/recipe/ingredients?ingredients=apple,rice&number=10
```