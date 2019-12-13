package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class ContaBancariaVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String banco;
    private String nragencia;
    private String dvagencia;
    private String nrconta;
    private String dvconta;
    private String TipoConta;

    protected ContaBancariaVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        banco = in.readString();
        nragencia = in.readString();
        dvagencia = in.readString();
        nrconta = in.readString();
        dvconta = in.readString();
        TipoConta = in.readString();
    }

    public ContaBancariaVO() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(banco);
        dest.writeString(nragencia);
        dest.writeString(dvagencia);
        dest.writeString(nrconta);
        dest.writeString(dvconta);
        dest.writeString(TipoConta);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ContaBancariaVO> CREATOR = new Creator<ContaBancariaVO>() {
        @Override
        public ContaBancariaVO createFromParcel(Parcel in) {
            return new ContaBancariaVO(in);
        }

        @Override
        public ContaBancariaVO[] newArray(int size) {
            return new ContaBancariaVO[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNragencia() {
        return nragencia;
    }

    public void setNragencia(String nragencia) {
        this.nragencia = nragencia;
    }

    public String getDvagencia() {
        return dvagencia;
    }

    public void setDvagencia(String dvagencia) {
        this.dvagencia = dvagencia;
    }

    public String getNrconta() {
        return nrconta;
    }

    public void setNrconta(String nrconta) {
        this.nrconta = nrconta;
    }

    public String getDvconta() {
        return dvconta;
    }

    public void setDvconta(String dvconta) {
        this.dvconta = dvconta;
    }

    public String getTipoConta() {
        return TipoConta;
    }

    public void setTipoConta(String tipoConta) {
        TipoConta = tipoConta;
    }
}
