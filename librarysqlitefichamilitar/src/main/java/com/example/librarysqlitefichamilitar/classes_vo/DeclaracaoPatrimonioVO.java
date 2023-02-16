package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

public class DeclaracaoPatrimonioVO implements Parcelable {

    private int id;
    private int id_pessoa;
    private int id_bens;
    private String apresentou_decla_bens;
    private String acumula_cargo_funcao;
    private String descr;
    private int valor_bem;
    private String observacoes;

    public DeclaracaoPatrimonioVO() {
    }

    protected DeclaracaoPatrimonioVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        id_bens = in.readInt();
        valor_bem = in.readInt();
        apresentou_decla_bens = in.readString();
        acumula_cargo_funcao = in.readString();
        descr = in.readString();
        observacoes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeInt(id_bens);
        dest.writeInt(valor_bem);
        dest.writeString(apresentou_decla_bens);
        dest.writeString(acumula_cargo_funcao);
        dest.writeString(descr);
        dest.writeString(observacoes);
    }

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

    public int getId_bens() {
        return id_bens;
    }

    public void setId_bens(int id_bens) {
        this.id_bens = id_bens;
    }

    public String getApresentou_decla_bens() {
        return apresentou_decla_bens;
    }

    public void setApresentou_decla_bens(String apresentou_decla_bens) {
        this.apresentou_decla_bens = apresentou_decla_bens;
    }

    public String getAcumula_cargo_funcao() {
        return acumula_cargo_funcao;
    }

    public void setAcumula_cargo_funcao(String acumula_cargo_funcao) {
        this.acumula_cargo_funcao = acumula_cargo_funcao;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getValor_bem() {
        return valor_bem;
    }

    public void setValor_bem(int valor_bem) {
        this.valor_bem = valor_bem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DeclaracaoPatrimonioVO> CREATOR = new Creator<DeclaracaoPatrimonioVO>() {
        @Override
        public DeclaracaoPatrimonioVO createFromParcel(Parcel in) {
            return new DeclaracaoPatrimonioVO(in);
        }

        @Override
        public DeclaracaoPatrimonioVO[] newArray(int size) {
            return new DeclaracaoPatrimonioVO[size];
        }
    };
}
