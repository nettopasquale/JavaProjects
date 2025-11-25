create table tbMedico(
      Cpf_Medico varchar2(11) PRIMARY KEY,
      Crm_Medico varchar2(11) NOT NULL,
      Nome_Medico varchar2(60) NOT NULL,
      Endereco_Medico varchar2(60),
      Telefone_Medico varchar2(60),
      Especialidade_Medico varchar2(60) NOT NULL
);

create table tbPaciente(
    Cpf_Paciente varchar2(11) PRIMARY KEY,
    Nome_Paciente varchar2(60),
    Endereco_Paciente varchar2(60),
    Telefone_Paciente varchar2(60),
    DataNascimento_Paciente date,
    Altura_Paciente number(3,2),
    Peso_Paciente number(6,2)
);

create table tbConsulta(
    Codigo_Consulta number(6) PRIMARY KEY,
    CPFMedico_Consulta varchar2(11),
    CPFPaciente_Consulta varchar2(11),
    Data_Consulta varchar2(60),
    Valor_Consulta number(6,2)
);

create table tbMedicacao(
    Nome_Medicacao varchar2(60) PRIMARY KEY,
    CodigoConsulta_Medicacao number(6),
    Dosagem_Medicacao varchar2(60),
    QtdDias_Medicacao number(3)
);

create table tbExame(
    Codigo_Exame number(6) PRIMARY KEY,
    CodigoConsulta_Exame number(6),
    Descricao_Exame varchar2(100),
    Data_Exame varchar2(60),
    Horario_Exame varchar2(60),
    Valor_Exame number(6,2)
);

-- CHAVES ESTRANGEIRAS PARA RELACIONAMENTO --

-- Paciente p/ Consulta

-- Consulta p/ Médico
ALTER TABLE tbConsulta ADD CONSTRAINT fk_consulta_medico
    FOREIGN KEY (CPFMedico_Consulta)
    REFERENCES tbMedico (Cpf_Medico);
-- Consulta p/ Paciente
ALTER TABLE tbConsulta ADD CONSTRAINT fk_consulta_paciente
    FOREIGN KEY (CPFPaciente_Consulta)
    REFERENCES tbPaciente (Cpf_Paciente);
    -- Consulta p/ Medicacao    
ALTER TABLE tbConsulta ADD CONSTRAINT fk_consulta_medicacao
    FOREIGN KEY (NomeMedicacao_Consulta)
    REFERENCES tbMedicacao (Nome_Medicacao);
-- Medicação p/ Consulta    
ALTER TABLE tbMedicacao ADD CONSTRAINT fk_medicacao_consulta
    FOREIGN KEY (CodigoConsulta_Medicacao)
    REFERENCES tbConsulta (Codigo_Consulta);
-- Exame p/ Consulta
ALTER TABLE tbExame ADD CONSTRAINT fk_exame_consulta
    FOREIGN KEY (CodigoConsulta_Exame)
    REFERENCES tbConsulta (Codigo_Consulta);
    
    -- Retirar FK de Consulta em Medicacao  
    ALTER TABLE tbMedicacao DROP CONSTRAINT fk_medicacao_consulta;
    
        -- Retirar FK de Paciente em Consulta    
    ALTER TABLE tbConsulta DROP CONSTRAINT fk_consulta_paciente;
    
    

select * from tbPaciente;
select * from tbMedico;
select * from tbConsulta;
select * from tbExame;

select * from tbMedicacao;

