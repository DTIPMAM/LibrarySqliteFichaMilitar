package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class MedalhasCondecoracoesVO implements Parcelable {
    private int id;
    private int id_pessoa;
    private String medalhaCondecoracao;
    private String data_condecoracao;
    private String data_boletim;
    private String numero_boletim;

    protected MedalhasCondecoracoesVO(Parcel in) {
        id = in.readInt();
        id_pessoa = in.readInt();
        medalhaCondecoracao = in.readString();
        data_condecoracao = in.readString();
        data_boletim = in.readString();
        numero_boletim = in.readString();
    }

    public MedalhasCondecoracoesVO() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(id_pessoa);
        dest.writeString(medalhaCondecoracao);
        dest.writeString(data_condecoracao);
        dest.writeString(data_boletim);
        dest.writeString(numero_boletim);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MedalhasCondecoracoesVO> CREATOR = new Creator<MedalhasCondecoracoesVO>() {
        @Override
        public MedalhasCondecoracoesVO createFromParcel(Parcel in) {
            return new MedalhasCondecoracoesVO(in);
        }

        @Override
        public MedalhasCondecoracoesVO[] newArray(int size) {
            return new MedalhasCondecoracoesVO[size];
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

    public String getMedalhaCondecoracao() {
        return medalhaCondecoracao;
    }

    public void setMedalhaCondecoracao(String medalhaCondecoracao) {
        this.medalhaCondecoracao = medalhaCondecoracao;
    }

    public String getData_condecoracao() {
        return data_condecoracao;
    }

    public void setData_condecoracao(String data_condecoracao) {
        this.data_condecoracao = data_condecoracao;
    }

    public String getData_boletim() {
        return data_boletim;
    }

    public void setData_boletim(String data_boletim) {
        this.data_boletim = data_boletim;
    }

    public String getNumero_boletim() {
        return numero_boletim;
    }

    public void setNumero_boletim(String numero_boletim) {
        this.numero_boletim = numero_boletim;
    }
}
