package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Cliente;
import br.com.zup.desafiocdc.modelo.Estado;
import br.com.zup.desafiocdc.modelo.Pais;
import br.com.zup.desafiocdc.validation.CpfOuCnpj;
import br.com.zup.desafiocdc.validation.EstadoObrigatorio;
import br.com.zup.desafiocdc.validation.IdExists;
import br.com.zup.desafiocdc.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoObrigatorio
public class ClienteRequestDto {

    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = Cliente.class)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CpfOuCnpj
    @UniqueValue(fieldName = "documento", domainClass = Cliente.class)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @IdExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public ClienteRequestDto() {
    }

    public Cliente toModel() {
        Cliente cliente = new Cliente(
                email,
                nome,
                sobrenome,
                documento,
                endereco,
                complemento,
                cidade,
                new Pais((Long) paisId),
                telefone,
                cep
        );
        if (estadoId != null) {
            cliente.setEstado(new Estado((Long) estadoId));
        }
        return cliente;
    }
}
