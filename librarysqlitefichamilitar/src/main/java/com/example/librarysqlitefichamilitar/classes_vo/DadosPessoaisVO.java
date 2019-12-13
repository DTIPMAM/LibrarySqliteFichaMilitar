package com.example.librarysqlitefichamilitar.classes_vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MSM on 05/06/2017.
 */

public class DadosPessoaisVO implements Parcelable {
    private int id;
    private String cpf;
    private String rg;
    private String matricula;
    private String data_nasc;
    private String nome;
    private String nome_pai;
    private String nome_mae;
    private String naturaldo;
    private String cidadenatal;
    private String alistmilitar;
    private String dsexo;
    private String estado_civil;
    private String religiao;
    private String pis_pasep;
    private String ctps_numero;
    private String ctps_serie;
    private String ctps_uf;
    private String nr_titulo;
    private String zona;
    private String secao;
    private String uf;
    private String barba;
    private String bigode;
    private String cabCor;
    private String cabTipo;
    private String cabTom;
    private String cutis;
    private String olhosCor;
    private String olhostom;
    private String Categoria;
    private String nro_registro;
    private String data_validade;
    private String update_atualizado;
    private String update_nome;
    private String update_username;
    private String update_email;
    private String cep;
    private String bairro;
    private String numero;
    private String cidade;
    private String estado;
    private String logradouro;
    private String complemento;
    private String telefone_fixo_pessoal;
    private String telefone_celular_pessoal1;
    private String telefone_celular_pessoal2;
    private String telefone_celular_pessoal3;
    private String telefone_celular_corporativo;
    private String email_institucional;
    private String email_pessoal;
    private String data_atualiz;
    private String whoupdate;

    public DadosPessoaisVO() {
    }

    protected DadosPessoaisVO(Parcel in) {
        id = in.readInt();
        cpf = in.readString();
        rg = in.readString();
        matricula = in.readString();
        data_nasc = in.readString();
        nome = in.readString();
        nome_pai = in.readString();
        nome_mae = in.readString();
        naturaldo = in.readString();
        cidadenatal = in.readString();
        alistmilitar = in.readString();
        dsexo = in.readString();
        estado_civil = in.readString();
        religiao = in.readString();
        pis_pasep = in.readString();
        ctps_numero = in.readString();
        ctps_serie = in.readString();
        ctps_uf = in.readString();
        nr_titulo = in.readString();
        zona = in.readString();
        secao = in.readString();
        uf = in.readString();
        barba = in.readString();
        bigode = in.readString();
        cabCor = in.readString();
        cabTipo = in.readString();
        cabTom = in.readString();
        cutis = in.readString();
        olhosCor = in.readString();
        olhostom = in.readString();
        Categoria = in.readString();
        nro_registro = in.readString();
        data_validade = in.readString();
        update_atualizado = in.readString();
        update_nome = in.readString();
        update_username = in.readString();
        update_email = in.readString();
        cep = in.readString();
        bairro = in.readString();
        numero = in.readString();
        cidade = in.readString();
        estado = in.readString();
        logradouro = in.readString();
        complemento = in.readString();
        telefone_fixo_pessoal = in.readString();
        telefone_celular_pessoal1 = in.readString();
        telefone_celular_pessoal2 = in.readString();
        telefone_celular_pessoal3 = in.readString();
        telefone_celular_corporativo = in.readString();
        email_institucional = in.readString();
        email_pessoal = in.readString();
        data_atualiz = in.readString();
        whoupdate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cpf);
        dest.writeString(rg);
        dest.writeString(matricula);
        dest.writeString(data_nasc);
        dest.writeString(nome);
        dest.writeString(nome_pai);
        dest.writeString(nome_mae);
        dest.writeString(naturaldo);
        dest.writeString(cidadenatal);
        dest.writeString(alistmilitar);
        dest.writeString(dsexo);
        dest.writeString(estado_civil);
        dest.writeString(religiao);
        dest.writeString(pis_pasep);
        dest.writeString(ctps_numero);
        dest.writeString(ctps_serie);
        dest.writeString(ctps_uf);
        dest.writeString(nr_titulo);
        dest.writeString(zona);
        dest.writeString(secao);
        dest.writeString(uf);
        dest.writeString(barba);
        dest.writeString(bigode);
        dest.writeString(cabCor);
        dest.writeString(cabTipo);
        dest.writeString(cabTom);
        dest.writeString(cutis);
        dest.writeString(olhosCor);
        dest.writeString(olhostom);
        dest.writeString(Categoria);
        dest.writeString(nro_registro);
        dest.writeString(data_validade);
        dest.writeString(update_atualizado);
        dest.writeString(update_nome);
        dest.writeString(update_username);
        dest.writeString(update_email);
        dest.writeString(cep);
        dest.writeString(bairro);
        dest.writeString(numero);
        dest.writeString(cidade);
        dest.writeString(estado);
        dest.writeString(logradouro);
        dest.writeString(complemento);
        dest.writeString(telefone_fixo_pessoal);
        dest.writeString(telefone_celular_pessoal1);
        dest.writeString(telefone_celular_pessoal2);
        dest.writeString(telefone_celular_pessoal3);
        dest.writeString(telefone_celular_corporativo);
        dest.writeString(email_institucional);
        dest.writeString(email_pessoal);
        dest.writeString(data_atualiz);
        dest.writeString(whoupdate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DadosPessoaisVO> CREATOR = new Creator<DadosPessoaisVO>() {
        @Override
        public DadosPessoaisVO createFromParcel(Parcel in) {
            return new DadosPessoaisVO(in);
        }

        @Override
        public DadosPessoaisVO[] newArray(int size) {
            return new DadosPessoaisVO[size];
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNaturaldo() {
        return naturaldo;
    }

    public void setNaturaldo(String naturaldo) {
        this.naturaldo = naturaldo;
    }

    public String getCidadenatal() {
        return cidadenatal;
    }

    public void setCidadenatal(String cidadenatal) {
        this.cidadenatal = cidadenatal;
    }

    public String getAlistmilitar() {
        return alistmilitar;
    }

    public void setAlistmilitar(String alistmilitar) {
        this.alistmilitar = alistmilitar;
    }

    public String getDsexo() {
        return dsexo;
    }

    public void setDsexo(String dsexo) {
        this.dsexo = dsexo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public String getPis_pasep() {
        return pis_pasep;
    }

    public void setPis_pasep(String pis_pasep) {
        this.pis_pasep = pis_pasep;
    }

    public String getCtps_numero() {
        return ctps_numero;
    }

    public void setCtps_numero(String ctps_numero) {
        this.ctps_numero = ctps_numero;
    }

    public String getCtps_serie() {
        return ctps_serie;
    }

    public void setCtps_serie(String ctps_serie) {
        this.ctps_serie = ctps_serie;
    }

    public String getCtps_uf() {
        return ctps_uf;
    }

    public void setCtps_uf(String ctps_uf) {
        this.ctps_uf = ctps_uf;
    }

    public String getNr_titulo() {
        return nr_titulo;
    }

    public void setNr_titulo(String nr_titulo) {
        this.nr_titulo = nr_titulo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBarba() {
        return barba;
    }

    public void setBarba(String barba) {
        this.barba = barba;
    }

    public String getBigode() {
        return bigode;
    }

    public void setBigode(String bigode) {
        this.bigode = bigode;
    }

    public String getCabCor() {
        return cabCor;
    }

    public void setCabCor(String cabCor) {
        this.cabCor = cabCor;
    }

    public String getCabTipo() {
        return cabTipo;
    }

    public void setCabTipo(String cabTipo) {
        this.cabTipo = cabTipo;
    }

    public String getCabTom() {
        return cabTom;
    }

    public void setCabTom(String cabTom) {
        this.cabTom = cabTom;
    }

    public String getCutis() {
        return cutis;
    }

    public void setCutis(String cutis) {
        this.cutis = cutis;
    }

    public String getOlhosCor() {
        return olhosCor;
    }

    public void setOlhosCor(String olhosCor) {
        this.olhosCor = olhosCor;
    }

    public String getOlhostom() {
        return olhostom;
    }

    public void setOlhostom(String olhostom) {
        this.olhostom = olhostom;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getNro_registro() {
        return nro_registro;
    }

    public void setNro_registro(String nro_registro) {
        this.nro_registro = nro_registro;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public String getUpdate_atualizado() {
        return update_atualizado;
    }

    public void setUpdate_atualizado(String update_atualizado) {
        this.update_atualizado = update_atualizado;
    }

    public String getUpdate_nome() {
        return update_nome;
    }

    public void setUpdate_nome(String update_nome) {
        this.update_nome = update_nome;
    }

    public String getUpdate_username() {
        return update_username;
    }

    public void setUpdate_username(String update_username) {
        this.update_username = update_username;
    }

    public String getUpdate_email() {
        return update_email;
    }

    public void setUpdate_email(String update_email) {
        this.update_email = update_email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone_fixo_pessoal() {
        return telefone_fixo_pessoal;
    }

    public void setTelefone_fixo_pessoal(String telefone_fixo_pessoal) {
        this.telefone_fixo_pessoal = telefone_fixo_pessoal;
    }

    public String getTelefone_celular_pessoal1() {
        return telefone_celular_pessoal1;
    }

    public void setTelefone_celular_pessoal1(String telefone_celular_pessoal1) {
        this.telefone_celular_pessoal1 = telefone_celular_pessoal1;
    }

    public String getTelefone_celular_pessoal2() {
        return telefone_celular_pessoal2;
    }

    public void setTelefone_celular_pessoal2(String telefone_celular_pessoal2) {
        this.telefone_celular_pessoal2 = telefone_celular_pessoal2;
    }

    public String getTelefone_celular_pessoal3() {
        return telefone_celular_pessoal3;
    }

    public void setTelefone_celular_pessoal3(String telefone_celular_pessoal3) {
        this.telefone_celular_pessoal3 = telefone_celular_pessoal3;
    }


    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

    public String getEmail_pessoal() {
        return email_pessoal;
    }

    public void setEmail_pessoal(String email_pessoal) {
        this.email_pessoal = email_pessoal;
    }

    public String getTelefone_celular_corporativo() {
        return telefone_celular_corporativo;
    }

    public void setTelefone_celular_corporativo(String telefone_celular_corporativo) {
        this.telefone_celular_corporativo = telefone_celular_corporativo;
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