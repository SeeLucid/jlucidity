SRC:=	src
BIN:=	bin
CFG:=	config
TEST:=	test

CLASSPATH:=$(BIN)
JAVA:=java -classpath $(CLASSPATH)
JAVAC:=javac -classpath $(CLASSPATH)
JAVAC_FLAGS:= -d $(BIN) -encoding UTF-8

JAVADOC_DIR:=	doc
JAVADOC_TITLE:=	JLucidity
JAVADOC_HEADER:=	<b>JLucidity</b>
JAVADOC_LINK:=	http://java.sun.com/j2se/1.5.0/docs/api/
JAVADOC_FLAGS:= -encoding UTF-8 -docencoding UTF-8 \
	-header "$(JAVADOC_HEADER)"  -doctitle "$(JAVADOC_TITLE)" -d "$(JAVADOC_DIR)" -link "$(JAVADOC_LINK)"

MKDIR:=mkdir
RM:=rm -f
RMDIR:=$(RM) -R

# clear
.SUFFIXES:
.SUFFIXES:	.java .class
$(BIN)/%.class:	$(SRC)/%.java
	$(JAVAC) $(JAVAC_FLAGS) $<
