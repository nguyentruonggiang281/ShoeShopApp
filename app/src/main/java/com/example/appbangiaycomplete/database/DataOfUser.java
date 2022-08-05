package com.example.appbangiaycomplete.database;

import android.database.Cursor;

import com.example.appbangiaycomplete.Image;
import com.example.appbangiaycomplete.ProductAdmin;

import java.util.ArrayList;

public class DataOfUser {// Class này để thao tác với Database.Tất cả đều static nên dùng tên lớp gọi là ra
    public static String idUser = "";
    private static DataBase dataBase;
    private static final String[] typeBrand = {"nike", "adidas", "mizuno"};

    public static ArrayList<ProductAdmin> getAllProduct() {
        //list img defaul
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<ProductAdmin> products = new ArrayList<>();
        Cursor data = dataBase.getData("SELECT p.idprod, p.nameProd,p.brand,p.price,pd.quantity,p.desc, pd.size,pd.color FROM Product p JOIN ProductDetails pd ON p.idProd = pd.idProd");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    products.add(new ProductAdmin(data.getString(0), listImage, data.getString(1), data.getString(2),Integer.parseInt(data.getString(3)),Integer.parseInt(data.getString(4)), data.getString(5), Integer.parseInt(data.getString(6)),data.getString(7) ));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return products;
    }

    public void insertProduct(String idProc, int imageProduct, String productName, String brand, int price, int amount, String description, int size, String color) {
        Cursor data = dataBase.getData("SELECT * FROM Product");

    }
/*
    public static ArrayList<Product> getAllProduct() {
        //list img defaul
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<Product> products = new ArrayList<>();
        Cursor data = dataBase.getData("SELECT * FROM Product");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                           } while (dataImg.moveToNext());
                        }
                    }
                    products.add(new Product(data.getString(0), listImage, data.getString(1), data.getString(2), Integer.parseInt(data.getString(3)), data.getString(4), isFavorite(data.getString(0))));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return products;
    }

    public static ArrayList<Product> getProductsByBrand(String brand) {
        //list img defaul
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<Product> products = new ArrayList<>();
        Cursor data = dataBase.getData("SELECT * FROM Product");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    if (brand.equalsIgnoreCase("other")) {
                        if (!isInTypeBrand(data.getString(2)))
                            products.add(new Product(data.getString(0), listImage, data.getString(1), data.getString(2), Integer.parseInt(data.getString(3)), data.getString(4), isFavorite(data.getString(0))));
                    } else if (data.getString(2).equalsIgnoreCase(brand))
                        products.add(new Product(data.getString(0), listImage, data.getString(1), data.getString(2), Integer.parseInt(data.getString(3)), data.getString(4), isFavorite(data.getString(0))));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return products;
    }

    public static Product getProductByID(String id) {
        ArrayList<Image> listImage = new ArrayList<Image>();
        Cursor data = dataBase.getData("SELECT * FROM Product WHERE idProd = '" + id + "'");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    return new Product(data.getString(0), listImage, data.getString(1), data.getString(2), Integer.parseInt(data.getString(3)), data.getString(4), isFavorite(data.getString(0)));
                } while (data.moveToNext());
            }
        }
        return null;
    }

    public static ArrayList<Product> getFavorProduct() {
        //list img defaul
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<String> idProdFavor = new ArrayList<>();
        Cursor tableFavor = dataBase.getData("SELECT idprod FROM Favorite WHERE username = '" + idUser + "'");
        if (tableFavor != null) {
            if (tableFavor.moveToFirst()) {
                do {
                    idProdFavor.add(tableFavor.getString(0));
                } while (tableFavor.moveToNext());
            }
        } else return products;

        if (idProdFavor.isEmpty()) return products;
        String idProds = "";
        for (String s : idProdFavor) {
            idProds += "'" + s + "',";
        }
        idProds = idProds.substring(0, idProds.length() - 1);

        Cursor data = dataBase.getData("SELECT * FROM Product WHERE idprod IN (" + idProds + ")");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    products.add(new Product(data.getString(0), listImage, data.getString(1), data.getString(2), Integer.parseInt(data.getString(3)), data.getString(4), true));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return products;
    }

    public static void setFavorProduct(String idProd, boolean isFavor) {
        if (isFavor) {
            dataBase.queryData("INSERT INTO Favorite VALUES('" + idUser + "', '" + idProd + "')");
        } else {
            dataBase.queryData("DELETE FROM Favorite WHERE username = '" + idUser + "' AND idprod = '" + idProd + "'");
        }
    }

    public static void setDataBase(DataBase db) {
        dataBase = db;

    }

    public static void setDataBase(Context c) {
        dataBase = new DataBase(c, "shopgiay.sqlite", null, 1);

    }

    public static void setIdUser(String id) {
        idUser = id;
    }

    private static boolean isInTypeBrand(String s) {
        for (String brand : typeBrand) {
            if (s.equalsIgnoreCase(brand)) return true;
        }
        return false;
    }

    private static boolean isFavorite(String idProd) {
        Cursor data = dataBase.getData("SELECT * FROM Favorite WHERE username = '" + idUser + "' AND idprod = '" + idProd + "'");
        if (data.moveToNext()) {
            return true;
        }
        return false;
    }

    public static String getIdProductsDetail(String idProduct, int size, String color) {
        Cursor data = dataBase.getData("SELECT idProdDetails FROM ProductDetails WHERE idProd  = '" + idProduct + "' AND size = " + size + " and color = '" + color + "' ");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    return data.getString(0);
                } while (data.moveToNext());
            }
        }
        return null;
    }

    public static int getAmountDetailsInCart(String idDetails) {//chưa tồn tại thì trả về 0,còn có thì trả về số lượng
        Cursor data = dataBase.getData("SELECT amountCart FROM Cart WHERE userName  = '" + idUser + "' AND idProdDetails = '" + idDetails + "'");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    return data.getInt(0);
                } while (data.moveToNext());
            }
        }
        return 0;
    }

    public static void insertCart(int amount, String idProdDetails) {
        dataBase.queryData("INSERT INTO Cart (userName,idProdDetails,amountCart) VALUES ( '" + idUser + "' , '" + idProdDetails + "'  , '" + amount + "' ); ");
    }

    public static void updateCart(int newAmount, String idProdDetails) {
        dataBase.queryData("UPDATE Cart SET amountCart = " + newAmount + " WHERE userName  = '" + idUser + "' AND idProdDetails = '" + idProdDetails + "'");
    }

    public static ArrayList<CartItem> getListProductDetailsCart() {
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<CartItem> cartItems = new ArrayList<>();
        Cursor data = dataBase.getData
                ("SELECT Product.idProd,nameprod,brand,price,amountcart,size,color,desc FROM Product,ProductDetails,Cart WHERE username = '" +
                        idUser + "' AND Product.idProd == ProductDetails.idProd AND ProductDetails.idProdDetails = Cart.idProdDetails");

        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    cartItems.add(new CartItem(data.getString(0), data.getString(1), data.getString(2),
                            listImage, data.getInt(3), data.getInt(4), data.getInt(5), data.getString(6), data.getString(7)));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return cartItems;
    }

    public static ArrayList<String> getSizeExist(String idProd, String color) {
        ArrayList<String> result = new ArrayList<>();
        if (color.equals("")) {//lấy tất cả size của sản phẩm
            Cursor data = dataBase.getData("SELECT DISTINCT size FROM ProductDetails WHERE idProd  = '" + idProd + "' ORDER BY size");
            if (data != null) {
                if (data.moveToFirst()) {
                    do {
                        result.add(String.valueOf(data.getInt(0)));
                    } while (data.moveToNext());
                }
            }
        } else {// lấy size của sản phẩm theo màu
            Cursor data = dataBase.getData("SELECT DISTINCT size FROM ProductDetails WHERE idProd  = '" + idProd + "' AND color = '" + color + "' ORDER BY size");
            if (data != null) {
                if (data.moveToFirst()) {
                    do {
                        result.add(String.valueOf(data.getInt(0)));
                    } while (data.moveToNext());
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getColorExist(String idProd, int size) {
        ArrayList<String> result = new ArrayList<>();
        if (size < 1) {//lấy tất cả màu của sản phẩm
            Cursor data = dataBase.getData("SELECT color FROM ProductDetails WHERE idProd  = '" + idProd + "'");
            if (data != null) {
                if (data.moveToFirst()) {
                    do {
                        result.add(data.getString(0).toString());
                    } while (data.moveToNext());
                }
            }
        } else {// lấy màu của sản phẩm theo size
            Cursor data = dataBase.getData("SELECT color FROM ProductDetails WHERE idProd  = '" + idProd + "' AND size = " + size);
            if (data != null) {
                if (data.moveToFirst()) {
                    do {
                        result.add(data.getString(0).toString());
                    } while (data.moveToNext());
                }
            }
        }
        return result;
    }



    //chưa viết xong thằng này đừng có sài
    public static String getCustomerInfor(String nameInfor) {
        String re = "";
        return re;
    }*/

}
