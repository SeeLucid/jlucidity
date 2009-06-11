BYTECODE:=	$(subst $(SRC),$(BIN),$(patsubst %.java,%.class,$(shell find $(SRC)\/jlucidity\/bytecode -name *.java)))

$(BYTECODE):	$(wildcard $(SRC)/jlucidity/bytecode/*.java)
		$(JAVAC) $(JAVAC_FLAGS) $+
