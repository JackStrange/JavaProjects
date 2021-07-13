import java.util.ArrayList;
public class LanguageBase{
	
}
class Regex{
	public String regex;

	public static NFAE toNFAE(Regex regex){
		return null;
	}
	public static NFA toNFA(Regex regex){
		return NFAE.toNFA(toNFAE(regex));
	}
	public static DFA toDFA(Regex regex){
		return NFA.toDFA(toNFA(regex));
	}
}
class TransFunc{
	public Integer start;
	public Character symbol;
	public Integer end;
}
abstract class Automaton{
	public ArrayList<Integer> states;
	public Integer start;
	public ArrayList<Integer> accepting;
	public ArrayList<TransFunc> delta;
}
class DFA extends Automaton{
	public static Regex toRegex(DFA dfa){
		return null;
	}
	public static NFAE toNFAE(DFA dfa){
		return Regex.toNFAE(toRegex(dfa));
	}
	public static NFA toNFA(DFA dfa){
		return NFAE.toNFA(toNFAE(dfa));
	}
}
class NFA extends Automaton{
	public static DFA toDFA(NFA nfa){
		return null;
	}
	public static Regex toRegex(NFA nfa){
		return DFA.toRegex(toDFA(nfa));
	}
	public static NFAE toNFAE(NFA nfa){
		return Regex.toNFAE(toRegex(nfa));
	}
}
class NFAE extends Automaton{
	public static NFA toNFA(NFAE nfae){
		NFA nfa = new NFA();
		for(Integer state:nfae.states) nfa.states.add(state);
		nfa.start = nfae.start;
		for(Integer state:nfae.accepting) nfa.accepting.add(state);
		for(TransFunc function:nfae.delta) nfa.delta.add(function);
		boolean valid = false;
		while(!valid){
			valid = true;
			for(TransFunc function:nfa.delta){
				if(function.symbol == "epsilon"){
					valid = false;
					if(!nfa.accepting.contains(function.start)) nfa.accepting.add(function.start);
					nfa.delta.remove(function);
				}
			}
		}

		return nfa;
	}
	public static DFA toDFA(NFAE nfae){
		return NFA.toDFA(toNFA(nfae));
	}
	public static Regex toRegex(NFAE nfae){
		return DFA.toRegex(toDFA(nfae));
	}
}