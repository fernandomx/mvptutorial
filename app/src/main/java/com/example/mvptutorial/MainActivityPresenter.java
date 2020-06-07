package com.example.mvptutorial;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        //EMAIL: teste@gmail.com
        //PASSWORD: teste123

        if (email.equals("teste@gmail.com") && password.equals("teste123")) {
            view.onSucess("SUCESSO !!!");
        } else {
             view.onError("Email ou senha inválido!!!");
        }


    }
}
