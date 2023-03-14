package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

public class DeclaracaoPatrimonioVO implements Parcelable {

    private int id;
    private int id_pessoa;
    private int id_tipo_bens;
    private String apresentou_decla_bens;
    private String acumula_cargo_funcao;
    private String descr;
    private float valor_bem;
    private String observacoes;
    private String data_criacao;

    public DeclaracaoPatrimonioVO() {
    }

    protected DeclaracaoPatrimonioVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        id_tipo_bens = in.readInt();
        valor_bem = in.readFloat();
        apresentou_decla_bens = in.readString();
        acumula_cargo_funcao = in.readString();
        descr = in.readString();
        observacoes = in.readString();
        data_criacao = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeInt(id_tipo_bens);
        dest.writeFloat(valor_bem);
        dest.writeString(apresentou_decla_bens);
        dest.writeString(acumula_cargo_funcao);
        dest.writeString(descr);
        dest.writeString(observacoes);
        dest.writeString(data_criacao);
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

    public int getId_tipo_bens() {
        return id_tipo_bens;
    }

    public void setId_tipo_bens(int id_tipo_bens) {
        this.id_tipo_bens = id_tipo_bens;
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

    public float getValor_bem() {
        return valor_bem;
    }

    public void setValor_bem(float valor_bem) {
        this.valor_bem = valor_bem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
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
