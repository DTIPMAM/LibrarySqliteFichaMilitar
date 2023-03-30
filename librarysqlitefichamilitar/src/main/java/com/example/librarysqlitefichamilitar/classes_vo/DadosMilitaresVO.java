package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class DadosMilitaresVO implements Parcelable {
    private int id;
    private String cpf;
    private String idt_militar;
    private String nome_guerra;
    private String antiguidade;
    private String data_exp_identidade;
    private String Funcao;
    private String PostoPatente;
    private String PostoQuadro;
    private String FuncaoGratificada;
    private String comportamento;
    private String data_inclusao;
    private String bg_inclusao;
    private String bg_inclusao_data;
    private String data_exclusao;
    private String bg_exclusao;
    private String bg_exclusao_data;
    private String tempo_servico;

    public DadosMilitaresVO() {
    }

    private String data_atualiz;
    private String whoupdate;

    protected DadosMilitaresVO(Parcel in) {
        id = in.readInt();
        cpf = in.readString();
        idt_militar = in.readString();
        nome_guerra = in.readString();
        antiguidade = in.readString();
        data_exp_identidade = in.readString();
        Funcao = in.readString();
        PostoPatente = in.readString();
        PostoQuadro = in.readString();
        FuncaoGratificada = in.readString();
        comportamento = in.readString();
        data_inclusao = in.readString();
        bg_inclusao = in.readString();
        bg_inclusao_data = in.readString();
        data_exclusao = in.readString();
        bg_exclusao = in.readString();
        bg_exclusao_data = in.readString();
        data_atualiz = in.readString();
        whoupdate = in.readString();
        tamanho_calca = in.readString();
        tamanho_camisa = in.readString();
        tamanho_sapato = in.readString();
        tamanho_gorro = in.readString();
        tamanho_gandola = in.readString();
        tamanho_calca_instrucao = in.readString();
        tamanho_canicola = in.readString();
        tamanho_calcao_tfm = in.readString();
        tamanho_coturno = in.readString();
        tamanho_saia = in.readString();
        lotacao = in.readString();
        status = in.readString();
        situacao = in.readString();
        tempo_servico = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cpf);
        dest.writeString(idt_militar);
        dest.writeString(nome_guerra);
        dest.writeString(antiguidade);
        dest.writeString(data_exp_identidade);
        dest.writeString(Funcao);
        dest.writeString(PostoPatente);
        dest.writeString(PostoQuadro);
        dest.writeString(FuncaoGratificada);
        dest.writeString(comportamento);
        dest.writeString(data_inclusao);
        dest.writeString(bg_inclusao);
        dest.writeString(bg_inclusao_data);
        dest.writeString(data_exclusao);
        dest.writeString(bg_exclusao);
        dest.writeString(bg_exclusao_data);
        dest.writeString(data_atualiz);
        dest.writeString(whoupdate);
        dest.writeString(tamanho_calca);
        dest.writeString(tamanho_camisa);
        dest.writeString(tamanho_sapato);
        dest.writeString(tamanho_gorro);
        dest.writeString(tamanho_gandola);
        dest.writeString(tamanho_calca_instrucao);
        dest.writeString(tamanho_canicola);
        dest.writeString(tamanho_calcao_tfm);
        dest.writeString(tamanho_coturno);
        dest.writeString(tamanho_saia);
        dest.writeString(lotacao);
        dest.writeString(status);
        dest.writeString(situacao);
        dest.writeString(tempo_servico);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DadosMilitaresVO> CREATOR = new Creator<DadosMilitaresVO>() {
        @Override
        public DadosMilitaresVO createFromParcel(Parcel in) {
            return new DadosMilitaresVO(in);
        }

        @Override
        public DadosMilitaresVO[] newArray(int size) {
            return new DadosMilitaresVO[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdt_militar() {
        return idt_militar;
    }

    public void setIdt_militar(String idt_militar) {
        this.idt_militar = idt_militar;
    }

    public String getNome_guerra() {
        return nome_guerra;
    }

    public void setNome_guerra(String nome_guerra) {
        this.nome_guerra = nome_guerra;
    }

    public String getAntiguidade() {
        return antiguidade;
    }

    public void setAntiguidade(String antiguidade) {
        this.antiguidade = antiguidade;
    }

    public String getData_exp_identidade() {
        return data_exp_identidade;
    }

    public void setData_exp_identidade(String data_exp_identidade) {
        this.data_exp_identidade = data_exp_identidade;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String funcao) {
        Funcao = funcao;
    }

    public String getPostoPatente() {
        return PostoPatente;
    }

    public void setPostoPatente(String postoPatente) {
        PostoPatente = postoPatente;
    }

    public String getPostoQuadro() {
        return PostoQuadro;
    }

    public void setPostoQuadro(String postoQuadro) {
        PostoQuadro = postoQuadro;
    }

    public String getFuncaoGratificada() {
        return FuncaoGratificada;
    }

    public void setFuncaoGratificada(String funcaoGratificada) {
        FuncaoGratificada = funcaoGratificada;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public String getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(String data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public String getBg_inclusao() {
        return bg_inclusao;
    }

    public void setBg_inclusao(String bg_inclusao) {
        this.bg_inclusao = bg_inclusao;
    }

    public String getBg_inclusao_data() {
        return bg_inclusao_data;
    }

    public void setBg_inclusao_data(String bg_inclusao_data) {
        this.bg_inclusao_data = bg_inclusao_data;
    }

    public String getData_exclusao() {
        return data_exclusao;
    }

    public void setData_exclusao(String data_exclusao) {
        this.data_exclusao = data_exclusao;
    }

    public String getBg_exclusao() {
        return bg_exclusao;
    }

    public void setBg_exclusao(String bg_exclusao) {
        this.bg_exclusao = bg_exclusao;
    }

    public String getBg_exclusao_data() {
        return bg_exclusao_data;
    }

    public void setBg_exclusao_data(String bg_exclusao_data) {
        this.bg_exclusao_data = bg_exclusao_data;
    }

    public String getTamanho_calca() {
        return tamanho_calca;
    }

    public void setTamanho_calca(String tamanho_calca) {
        this.tamanho_calca = tamanho_calca;
    }

    public String getTamanho_camisa() {
        return tamanho_camisa;
    }

    public void setTamanho_camisa(String tamanho_camisa) {
        this.tamanho_camisa = tamanho_camisa;
    }

    public String getTamanho_sapato() {
        return tamanho_sapato;
    }

    public void setTamanho_sapato(String tamanho_sapato) {
        this.tamanho_sapato = tamanho_sapato;
    }

    public String getTamanho_gorro() {
        return tamanho_gorro;
    }

    public void setTamanho_gorro(String tamanho_gorro) {
        this.tamanho_gorro = tamanho_gorro;
    }

    public String getTamanho_gandola() {
        return tamanho_gandola;
    }

    public void setTamanho_gandola(String tamanho_gandola) {
        this.tamanho_gandola = tamanho_gandola;
    }

    public String getTamanho_calca_instrucao() {
        return tamanho_calca_instrucao;
    }

    public void setTamanho_calca_instrucao(String tamanho_calca_instrucao) {
        this.tamanho_calca_instrucao = tamanho_calca_instrucao;
    }

    public String getTamanho_canicola() {
        return tamanho_canicola;
    }

    public void setTamanho_canicola(String tamanho_canicola) {
        this.tamanho_canicola = tamanho_canicola;
    }

    public String getTamanho_calcao_tfm() {
        return tamanho_calcao_tfm;
    }

    public void setTamanho_calcao_tfm(String tamanho_calcao_tfm) {
        this.tamanho_calcao_tfm = tamanho_calcao_tfm;
    }

    public String getTamanho_coturno() {
        return tamanho_coturno;
    }

    public void setTamanho_coturno(String tamanho_coturno) {
        this.tamanho_coturno = tamanho_coturno;
    }

    public String getTamanho_saia() {
        return tamanho_saia;
    }

    public void setTamanho_saia(String tamanho_saia) {
        this.tamanho_saia = tamanho_saia;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    private String tamanho_calca;
    private String tamanho_camisa;
    private String tamanho_sapato;
    private String tamanho_gorro;
    private String tamanho_gandola;
    private String tamanho_calca_instrucao;
    private String tamanho_canicola;
    private String tamanho_calcao_tfm;
    private String tamanho_coturno;
    private String tamanho_saia;
    private String lotacao;
    private String status;
    private String situacao;

    public String getTempo_servico() {
        return tempo_servico;
    }

    public void setTempo_servico(String tempo_servico) {
        this.tempo_servico = tempo_servico;
    }

    public String getData_atualiz() {
        return data_atualiz;
    }

    public void setData_atualiz(String data_atualiz) {
        this.data_atualiz = data_atualiz;
    }

    public String getWhoupdate() {
        return whoupdate;
    }

    public void setWhoupdate(String whoupdate) {
        this.whoupdate = whoupdate;
    }
}
