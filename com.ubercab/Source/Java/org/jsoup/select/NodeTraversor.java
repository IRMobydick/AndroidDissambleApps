package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor
{
  private NodeVisitor visitor;

  public NodeTraversor(NodeVisitor paramNodeVisitor)
  {
    this.visitor = paramNodeVisitor;
  }

  public void traverse(Node paramNode)
  {
    Node localNode = paramNode;
    int i = 0;
    while (true)
      if (localNode != null)
      {
        this.visitor.head(localNode, i);
        if (localNode.childNodeSize() > 0)
        {
          localNode = localNode.childNode(0);
          i++;
        }
        else
        {
          while ((localNode.nextSibling() == null) && (i > 0))
          {
            this.visitor.tail(localNode, i);
            localNode = localNode.parentNode();
            i--;
          }
          this.visitor.tail(localNode, i);
          if (localNode != paramNode);
        }
      }
      else
      {
        return;
        localNode = localNode.nextSibling();
      }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.select.NodeTraversor
 * JD-Core Version:    0.6.2
 */