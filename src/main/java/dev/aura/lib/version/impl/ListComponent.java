package dev.aura.lib.version.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.ToString;

@ToString(includeFieldNames = false)
public class ListComponent extends VersionComponent {
  private static final long serialVersionUID = -2227223164775220736L;

  protected final ArrayList<VersionComponent> components;

  protected ListComponent(Collection<VersionComponent> components) {
    this.components = new ArrayList<>(components);
  }

  protected ListComponent(Stream<VersionComponent> components) {
    this.components = components.collect(Collectors.toCollection(ArrayList<VersionComponent>::new));
  }

  protected ListComponent(VersionComponent... components) {
    this(Arrays.asList(components));
  }

  @Override
  public int compareTo(VersionComponent that) {
    if (that.getVersionComponentType() != VersionComponent.Type.LIST)
      return compareTo(new ListComponent(that));

    ListComponent thatList = (ListComponent) that;
    boolean empty = components.isEmpty();
    boolean thatEmpty = thatList.components.isEmpty();

    if (empty) return thatEmpty ? 0 : -1;
    else if (thatEmpty) return 1;

    int thisSize = components.size();
    int thatSize = thatList.components.size();
    int size = Math.max(thisSize, thatSize);
    VersionComponent thisComponent;
    VersionComponent thatComponent;
    int result;

    for (int i = 0; i < size; ++i) {
      if (i < thisSize) {
        thisComponent = components.get(i);
      } else {
        thisComponent = VersionParser.ZERO;
      }

      if (i < thatSize) {
        thatComponent = thatList.components.get(i);
      } else {
        thatComponent = VersionParser.ZERO;
      }

      result = thisComponent.compareTo(thatComponent);

      if (result != 0) return result;
    }

    return 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hash = 0;

    for (int i = components.size() - 1; i >= 0; --i) {
      hash = (hash * prime) + components.get(i).hashCode();
    }

    return hash;
  }

  @Override
  public final VersionComponent.Type getVersionComponentType() {
    return VersionComponent.Type.LIST;
  }
}
