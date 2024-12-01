package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	String url = "https://demo-opencart.com/";

	@DataProvider(name = "loadData")
    public Object[][] provideLoadData() {
        return new Object[][]{
                {"chrome", url},
                {"firefox", url}
        };
    }
	@DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"chrome", url, "johndue@example.com", "password123"},
                {"firefox", url,  "janesmith@example.com", "password456"}
        };
    }
	@DataProvider(name = "homeData")
    public Object[][] provideHomeData() {
        return new Object[][]{
                {"chrome", url},
                {"firefox", url}
        };
        
        

            
    }
    @DataProvider(name = "productCart")
    public Object[][] provideproductandCartData() {
            return new Object[][]{
                    {"HP LP3065"},
                    {"HP LP3065"}
            };
    }

    @DataProvider(name = "productQuantity")
    public Object[][] provideproductQuantityErrorData() {
                return new Object[][]{
                        {"HP LP3065", "invalid"},
                        {"HP LP3065", "invalid"}
                };
    }
    @DataProvider(name = "searchData")
    public Object[][] provideSearchData() {
        return new Object[][]{
                {"chrome", url, "laptop"},
                {"firefox", url, "phone"}
        };
    }

    @DataProvider(name = "registerData")
    public Object[][] provideRegisterData() {
        return new Object[][]{
                {"chrome", url, "John", "Doe", "johndooe@example.com", "password123"},
                {"edge", url, "Jane", "Smith", "janesmith@example.com", "password456"}
        };
    }
}
